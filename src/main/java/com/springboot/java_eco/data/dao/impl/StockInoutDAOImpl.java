package com.springboot.java_eco.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.common.CommonResponse;
import com.springboot.java_eco.data.dao.StockInoutDAO;
import com.springboot.java_eco.data.dto.common.CommonInfoSearchDto;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.stockInout.StockInoutDto;
import com.springboot.java_eco.data.entity.*;
import com.springboot.java_eco.data.repository.company.CompanyRepository;
import com.springboot.java_eco.data.repository.estimate.EstimateRepository;
import com.springboot.java_eco.data.repository.factory.FactoryRepository;
import com.springboot.java_eco.data.repository.factorySub.FactorySubRepository;
import com.springboot.java_eco.data.repository.item.ItemRepository;
import com.springboot.java_eco.data.repository.stockInout.StockInoutRepository;
import com.springboot.java_eco.data.repository.stockInout.StockInoutRepository;
import com.springboot.java_eco.data.repository.stockInoutSub.StockInoutSubRepository;
import com.springboot.java_eco.data.repository.user.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class StockInoutDAOImpl implements StockInoutDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(StockInoutDAOImpl.class);

    private final StockInoutRepository stockInoutRepository;
    private final StockInoutSubRepository stockInoutSubRepository;
    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    private final CompanyRepository companyRepository;
    
    private final FactoryRepository factoryRepository;
    private final FactorySubRepository factorySubRepository;
    
    @Autowired
    public StockInoutDAOImpl(
                            StockInoutRepository stockInoutRepository,
                             StockInoutSubRepository stockInoutSubRepository,
                             UserRepository userRepository,
                             ItemRepository itemRepository,
                             CompanyRepository companyRepository,
                             FactoryRepository factoryRepository,
                             FactorySubRepository factorySubRepository
                          ) {
        this.stockInoutRepository = stockInoutRepository;
        this.stockInoutSubRepository = stockInoutSubRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.companyRepository = companyRepository;
        this.factoryRepository = factoryRepository;
        this.factorySubRepository = factorySubRepository;
        
    }

    @Override
    public CommonResultDto insertStockInout(StockInoutDto stockInoutDto) throws Exception {

        Company company = companyRepository.findByUid(stockInoutDto.getCompany_uid());


        User user = userRepository.getById(stockInoutDto.getUser_id());


        StockInout stockInout = new StockInout();

        stockInout.setUser(user);
        stockInout.setCompany(company);
        stockInout.setCode(stockInoutDto.getCode());
        stockInout.setDoc_uid(stockInoutDto.getDoc_uid());
        stockInout.setDoc_type(stockInoutDto.getDoc_type());
        stockInout.setStatus(stockInoutDto.getStatus());
        stockInout.setCreated(LocalDateTime.now());
        StockInout insertStockInout = stockInoutRepository.save(stockInout);
        Long uid = insertStockInout.getUid();

        LOGGER.info("[uid] : {}",uid);
        StockInout selectedStockInout = stockInoutRepository.findByUid(uid);

        List<Map<String, Object>> stockInoutSubList = stockInoutDto.getStock_inout_sub();

        CommonResultDto CommonResultDto = new CommonResultDto();
        if (stockInoutSubList != null) {

            for (Map<String, Object> stockInoutSubData : stockInoutSubList) {
                StockInoutSub stockInoutSub = new StockInoutSub();

                stockInoutSub.setStockInout(selectedStockInout);
                if (stockInoutSubData.containsKey("item_uid")) {
                    Long itemUid = Long.parseLong(stockInoutSubData.get("item_uid").toString());
                    Item selectedItem = itemRepository.findByUid(itemUid);
                    stockInoutSub.setItem(selectedItem);
                }
                if (stockInoutSubData.containsKey("factory_uid")) {
                    Long factoryUid = Long.parseLong(stockInoutSubData.get("factory_uid").toString());
                    Factory selectedFactory = factoryRepository.findByUid(factoryUid);
                    stockInoutSub.setFactory(selectedFactory);
                }
                if (stockInoutSubData.containsKey("factory_sub_uid")) {
                    Long factorySubUid = Long.parseLong(stockInoutSubData.get("factory_sub_uid").toString());
                    FactorySub selectedFactorySub = factorySubRepository.findByUid(factorySubUid);
                    stockInoutSub.setFactorySub(selectedFactorySub);
                }

                stockInoutSub.setLot(stockInoutSubData.get("lot").toString());
                stockInoutSub.setQty(Double.valueOf(stockInoutSubData.get("qty").toString()));
                stockInoutSub.setUnit(stockInoutSubData.get("unit").toString());
                stockInoutSub.setStatus(stockInoutSubData.get("status").toString());
                stockInoutSub.setCreated(LocalDateTime.now());
                stockInoutSubRepository.save(stockInoutSub);


            }



            setSuccessResult(CommonResultDto);
            return CommonResultDto;

        }else {
            setFailResult(CommonResultDto);
            return CommonResultDto;

        }
    }


    @Override
    public CommonResultDto updateStockInout(StockInoutDto stockInoutDto) throws Exception {


        Company company = companyRepository.findByUid(stockInoutDto.getCompany_uid());

        User user = userRepository.getById(stockInoutDto.getUser_id());

        
        Optional<StockInout> selectedStockInout = stockInoutRepository.findById(String.valueOf(stockInoutDto.getUid()));

        StockInout updatedStockInout;

        if (selectedStockInout.isPresent()) {
            StockInout stockInout = selectedStockInout.get();
            stockInout.setCompany(company);
            stockInout.setUser(user);
            stockInout.setCode(stockInoutDto.getCode());
            stockInout.setDoc_uid(stockInoutDto.getDoc_uid());
            stockInout.setDoc_type(stockInoutDto.getDoc_type());
            stockInout.setStatus(stockInoutDto.getStatus());
            stockInout.setCreated(LocalDateTime.now());
            updatedStockInout = stockInoutRepository.save(stockInout);
        } else {
            throw new Exception();
        }


        List<Map<String, Object>> stockInoutSubList = stockInoutDto.getStock_inout_sub();

        LOGGER.info("[StockInout] : {}",selectedStockInout);
        CommonResultDto CommonResultDto = new CommonResultDto();

        if (stockInoutSubList != null) {

            List<StockInoutSub> deletedData = stockInoutSubRepository.findByStockInoutUid(stockInoutDto.getUid());
            stockInoutSubRepository.deleteAll(deletedData);
            for (Map<String, Object> stockInoutSubData : stockInoutSubList) {
                StockInoutSub stockInoutSub = new StockInoutSub();
                stockInoutSub.setStockInout(updatedStockInout);

                if (stockInoutSubData.containsKey("item_uid")) {
                    Long itemUid = Long.parseLong(stockInoutSubData.get("item_uid").toString());
                    Item selectedItem = itemRepository.findByUid(itemUid);
                    stockInoutSub.setItem(selectedItem);
                }
                if(stockInoutSubData.containsKey("factory_uid")){
                    Long factoryUid = Long.parseLong(stockInoutSubData.get("factory_uid").toString());
                    Factory selectedFactory = factoryRepository.findByUid(factoryUid);
                    stockInoutSub.setFactory(selectedFactory);
                }
                if(stockInoutSubData.containsKey("factory_sub_uid")){
                    Long factorySubUid = Long.parseLong(stockInoutSubData.get("factory_sub_uid").toString());
                    FactorySub selectedFactorySub = factorySubRepository.findByUid(factorySubUid);
                    stockInoutSub.setFactorySub(selectedFactorySub);
                }
                if (stockInoutSubData.get("lot") != null && !stockInoutSubData.get("lot").toString().isEmpty()) {
                    stockInoutSub.setLot(stockInoutSubData.get("lot").toString());
                } else {
                    stockInoutSub.setLot("");
                }


                if (stockInoutSubData.get("unit") != null && !stockInoutSubData.get("unit").toString().isEmpty()) {
                    stockInoutSub.setUnit(stockInoutSubData.get("unit").toString());
                } else {
                    stockInoutSub.setUnit("");
                }
                if (!stockInoutSubData.get("qty").toString().isEmpty()) {
                    try {
                        stockInoutSub.setQty(Double.valueOf(stockInoutSubData.get("qty").toString()));
                    } catch (NumberFormatException e) {
                        stockInoutSub.setQty((double) 0L);
                    }
                }
                if (stockInoutSubData.get("status") != null && !stockInoutSubData.get("status").toString().isEmpty()) {
                    stockInoutSub.setStatus(stockInoutSubData.get("status").toString());
                } else {
                    stockInoutSub.setStatus("가용");
                }
                stockInoutSub.setCreated(LocalDateTime.now());
                stockInoutSub.setUpdated(LocalDateTime.now());

                stockInoutSubRepository.save(stockInoutSub);
            }



            setSuccessResult(CommonResultDto);
            return CommonResultDto;

        }else {
            setFailResult(CommonResultDto);
            return CommonResultDto;

        }
    }


    @Override
    public List<StockInout> selectStockInout(CommonInfoSearchDto commonInfoSearchDto) {
        return stockInoutRepository.findInfo(commonInfoSearchDto);

    }

    @Override
    public List<StockInout> selectTotalStockInout(CommonSearchDto commonSearchDto) {
        return stockInoutRepository.findAll(commonSearchDto);

    }

    @Override
    public String deleteStockInout(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<StockInout> selectedStockInout = Optional.ofNullable(stockInoutRepository.findByUid(uid));
            if (selectedStockInout.isPresent()) {
                StockInout stockInout = selectedStockInout.get();
                stockInoutRepository.delete(stockInout);
            } else {
                throw new Exception("StockInout with UID " + uid + " not found.");
            }
        }
        return "StockInouts deleted successfully";
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