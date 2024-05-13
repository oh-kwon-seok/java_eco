package com.springboot.java_eco.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.common.CommonResponse;
import com.springboot.java_eco.data.dao.StockControlDAO;
import com.springboot.java_eco.data.dto.common.CommonInfoSearchDto;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.stockControl.StockControlDto;
import com.springboot.java_eco.data.entity.*;
import com.springboot.java_eco.data.repository.company.CompanyRepository;
import com.springboot.java_eco.data.repository.factory.FactoryRepository;
import com.springboot.java_eco.data.repository.factorySub.FactorySubRepository;
import com.springboot.java_eco.data.repository.item.ItemRepository;
import com.springboot.java_eco.data.repository.stockInout.StockInoutRepository;
import com.springboot.java_eco.data.repository.stockControl.StockControlRepository;
import com.springboot.java_eco.data.repository.user.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class StockControlDAOImpl implements StockControlDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(StockControlDAOImpl.class);

    private final StockControlRepository stockControlRepository;

    private final StockInoutRepository stockInoutRepository;

    private final ItemRepository itemRepository;

    private final CompanyRepository companyRepository;

    private final FactoryRepository factoryRepository;

    private final FactorySubRepository factorySubRepository;

    private final UserRepository userRepository;

    @Autowired
    public StockControlDAOImpl(StockControlRepository stockControlRepository,
                               StockInoutRepository stockInoutRepository,
                               FactoryRepository factoryRepository,
                               FactorySubRepository factorySubRepository,
                               ItemRepository itemRepository,
                               CompanyRepository companyRepository,
                               UserRepository userRepository

                          ) {
        this.stockControlRepository = stockControlRepository;
        this.factoryRepository = factoryRepository;
        this.factorySubRepository = factorySubRepository;
        this.stockInoutRepository = stockInoutRepository;
        this.itemRepository = itemRepository;
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommonResultDto insertStockControl(StockControlDto stockControlDto) throws Exception {

        Company company = companyRepository.findByUid(stockControlDto.getCompany_uid());
        Item item = itemRepository.findByUid(stockControlDto.getItem_uid());
        User user = userRepository.getById(stockControlDto.getUser_id());

        Factory prevfactory = factoryRepository.findByUid(stockControlDto.getPrev_factory_uid());
        FactorySub prevfactorySub = factorySubRepository.findByUid(stockControlDto.getPrev_factory_sub_uid());


        Factory afterFactory = factoryRepository.findByUid(stockControlDto.getAfter_factory_uid());
        FactorySub afterfactorySub = factorySubRepository.findByUid(stockControlDto.getAfter_factory_sub_uid());

        StockControl stockControl = new StockControl();

        stockControl.setItem(item);
        stockControl.setCompany(company);


        stockControl.setPrevFactory(prevfactory);
        stockControl.setPrevFactorySub(prevfactorySub);
        stockControl.setAfterFactory(afterFactory);
        stockControl.setAfterFactorySub(afterfactorySub);
        stockControl.setUser(user);

        stockControl.setPrev_qty(stockControlDto.getPrev_qty());

        stockControl.setAfter_qty(stockControlDto.getAfter_qty());

        stockControl.setUnit(stockControlDto.getUnit());
        stockControl.setStatus(stockControlDto.getStatus());
        stockControl.setControl_reason(stockControlDto.getControl_reason());


        stockControl.setLot(stockControlDto.getLot());

        stockControl.setCreated(LocalDateTime.now());


        StockControl insertStockControl = stockControlRepository.save(stockControl);

        Long uid = insertStockControl.getUid();


        StockControl selectedStockControl = stockControlRepository.findByUid(uid);

        CommonResultDto CommonResultDto = new CommonResultDto();
        if (selectedStockControl != null) {

            setSuccessResult(CommonResultDto);
            return CommonResultDto;

        }else {
            setFailResult(CommonResultDto);
            return CommonResultDto;

        }
    }

    @Override
    public List<StockControl> selectStockControl(CommonInfoSearchDto commonInfoSearchDto) {
        return stockControlRepository.findInfo(commonInfoSearchDto);

    }

    @Override
    public List<StockControl> selectTotalStockControl(CommonSearchDto commonSearchDto) {
        return stockControlRepository.findAll(commonSearchDto);

    }

    @Override
    public String deleteStockControl(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<StockControl> selectedStockControl = Optional.ofNullable(stockControlRepository.findByUid(uid));
            if (selectedStockControl.isPresent()) {
                StockControl stockControl = selectedStockControl.get();


                stockControlRepository.delete(stockControl);
            } else {
                throw new Exception("Stock with UID " + uid + " not found.");
            }
        }
        return "Stocks deleted successfully";
    }


    private void setSuccessResult(CommonResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(CommonResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }

}