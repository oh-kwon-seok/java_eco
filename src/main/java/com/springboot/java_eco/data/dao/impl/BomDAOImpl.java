package com.springboot.java_eco.data.dao.impl;

import com.springboot.java_eco.data.dao.BomDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.bom.BomDto;
import com.springboot.java_eco.data.entity.Company;
import com.springboot.java_eco.data.entity.Bom;
import com.springboot.java_eco.data.entity.Item;
import com.springboot.java_eco.data.repository.company.CompanyRepository;
import com.springboot.java_eco.data.repository.bom.BomRepository;
import com.springboot.java_eco.data.repository.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class BomDAOImpl implements BomDAO {

    private final BomRepository bomRepository;
    private final CompanyRepository companyRepository;

    private final ItemRepository itemRepository;


    @Autowired
    public BomDAOImpl(BomRepository bomRepository, CompanyRepository companyRepository, ItemRepository itemRepository){

        this.bomRepository = bomRepository;
        this.companyRepository = companyRepository;
        this.itemRepository = itemRepository;
    }

    public Bom insertBom(BomDto bomDto) {

        Company company = companyRepository.findByUid(bomDto.getCompany_uid());
        Item item = itemRepository.findByUid(bomDto.getItem_uid());


        Optional<Bom> selectedBom = Optional.ofNullable(bomRepository.findByCodeAndCompanyAndUsed(bomDto.getCode(), company, 1L));


        if (selectedBom.isPresent()) {
            Bom bom = selectedBom.get();
            bom.setCompany(company);
            bom.setItem(item);

            bom.setUsed(Math.toIntExact(bomDto.getUsed()));
            bom.setUpdated(LocalDateTime.now());
            return bomRepository.save(bom);
        } else {
            Bom bom = new Bom();
            bom.setCompany(company);
            bom.setItem(item);
            bom.setUsed(Math.toIntExact(bomDto.getUsed()));
            bom.setCreated(LocalDateTime.now());

            return bomRepository.save(bom);

        }

    }
    @Override
    public List<Bom> selectTotalBom(CommonSearchDto commonSearchDto) {
        return bomRepository.findAll(commonSearchDto);

    }

    @Override
    public List<Bom> selectBom(CommonSearchDto commonSearchDto) {
        return bomRepository.findInfo(commonSearchDto);

    }


    @Override
    public Bom updateBom(BomDto bomDto) throws Exception {

        Company company = companyRepository.findByUid(bomDto.getCompany_uid());
        Item item = itemRepository.findByUid(bomDto.getItem_uid());

        Optional<Bom> selectedBom = bomRepository.findById(bomDto.getUid());

        Bom updatedBom;

        if (selectedBom.isPresent()) {
            Bom bom = selectedBom.get();

            bom.setCompany(company);
            bom.setItem(item);
            bom.setUsed(Math.toIntExact(bomDto.getUsed()));

            bom.setUpdated(LocalDateTime.now());
            updatedBom = bomRepository.save(bom);
        } else {
            throw new Exception();
        }
        return updatedBom;
    }
    @Override
    public String deleteBom(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Bom> selectedBom = bomRepository.findById(uid);
            if (selectedBom.isPresent()) {
                Bom bom = selectedBom.get();
                bom.setUsed(0);
                bom.setDeleted(LocalDateTime.now());
                bomRepository.save(bom);
            } else {
                throw new Exception("Bom with UID " + uid + " not found.");
            }
        }
        return "Boms deleted successfully";
    }
//    @Override
//    public String excelUploadBom(List<Map<String, Object>> requestList) throws Exception {
//
//        for (Map<String, Object> data : requestList) {
//
//            String name = String.valueOf(data.get("name"));
//            String purpose = String.valueOf(data.get("purpose"));
//            String description = String.valueOf(data.get("description"));
//
//
//            String companyCode = String.valueOf(data.get("company_code"));
//
//            Company company = companyRepository.findByCode(companyCode);
//
//            // 예시로 이름과 수량이 모두 일치하는 Bom를 찾는 메서드를 가정
//            Optional<Bom> selectedBom = Optional.ofNullable(bomRepository.findByNameAndCompanyAndUsed(name, company,1L));
//            if (company != null) {
//                if (selectedBom.isPresent()) {
//                    Bom bom = selectedBom.get();
//                    bom.setCompany(company);
//                    bom.setName(name);
//                    bom.setPurpose(purpose);
//                    bom.setDescription(description);
//                    bom.setUsed(1);
//                    bom.setUpdated(LocalDateTime.now());
//                    bomRepository.save(bom);
//                } else {
//                    Bom bom = new Bom();
//
//                    bom.setCompany(company);
//                    bom.setName(name);
//                    bom.setPurpose(purpose);
//                    bom.setDescription(description);
//                    bom.setUsed(1);
//
//                    bom.setCreated(LocalDateTime.now());
//                    bomRepository.save(bom);
//
//
//                }
//
//            }
//
//
//        }
//        return "Boms deleted successfully";
//    }
}
