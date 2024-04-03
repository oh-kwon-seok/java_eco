package com.springboot.java_eco.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.common.CommonResponse;
import com.springboot.java_eco.data.dao.BomDAO;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.bom.BomDto;
import com.springboot.java_eco.data.entity.*;
import com.springboot.java_eco.data.repository.company.CompanyRepository;
import com.springboot.java_eco.data.repository.bom.BomRepository;
import com.springboot.java_eco.data.repository.item.ItemRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class BomDAOImpl implements BomDAO {
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(BomDAOImpl.class);
    private final BomRepository bomRepository;
    private final CompanyRepository companyRepository;

    private final ItemRepository itemRepository;


    @Autowired
    public BomDAOImpl(BomRepository bomRepository, CompanyRepository companyRepository, ItemRepository itemRepository){

        this.bomRepository = bomRepository;
        this.companyRepository = companyRepository;
        this.itemRepository = itemRepository;
    }

    public CommonResultDto insertBom(BomDto bomDto) {

        Company company = companyRepository.findByUid(bomDto.getCompany_uid());
        Item item = itemRepository.findByUid(bomDto.getItem_uid());


        Optional<Bom> selectedBom = Optional.ofNullable(bomRepository.findByCodeAndCompanyAndUsed(bomDto.getCode(), company, 1L));


        if (selectedBom.isPresent()) {
            Bom bom = selectedBom.get();
            bom.setCompany(company);
            bom.setItem(item);
            bom.setQty(bomDto.getQty());
            bom.setRate(bomDto.getRate());
            bom.setUsed(Math.toIntExact(bomDto.getUsed()));
            bom.setUpdated(LocalDateTime.now());

            Bom insertBom = bomRepository.save(bom);
            Long uid = insertBom.getUid();
            CommonResultDto CommonResultDto = new CommonResultDto();


            List<Map<String, Object>> bomSubList = bomDto.getBom_data();

            if (bomSubList != null) {

                for (Map<String, Object> bomSubData : bomSubList) {

                    if (bomSubData.containsKey("title")) {
                        String title = (String) bomSubData.get("title");
                        if ("main".equals(title)) {
                            // title 속성의 값이 'main'인 경우
                            Bom subBom = new Bom();
                            subBom.setParent_uid(uid);
                            // item_uid 값이 있다면 item를 가져옴
                            if (bomSubData.containsKey("item_uid")) {
                                Long itemUid = Long.parseLong(bomSubData.get("item_uid").toString());
                                Item selectedItem = itemRepository.findByUid(itemUid);
                                subBom.setItem(selectedItem);
                            }
                            if (bomSubData.containsKey("company_uid")) {
                                Long companyUid = Long.parseLong(bomSubData.get("company_uid").toString());
                                Company selectedCompany = companyRepository.findByUid(companyUid);
                                subBom.setCompany(selectedCompany);
                            }
                            subBom.setCode(bomSubData.get("code").toString());
                            subBom.setQty(Double.valueOf(bomSubData.get("qty").toString()));
                            subBom.setRate(Double.valueOf(bomSubData.get("rate").toString()));
                            // product_uid 값이 있다면 product를 가져와서 userProduct에 설정

                            subBom.setCreated(LocalDateTime.now());
                            subBom.setUsed(1);

                            bomRepository.save(subBom);


                        }
                    }



                }


                setSuccessResult(CommonResultDto);
                return CommonResultDto;

            }else {
                setFailResult(CommonResultDto);
                return CommonResultDto;

            }
        } else {
            Bom bom = new Bom();
            bom.setParent_uid(0L);
            bom.setCode(bomDto.getCode());
            bom.setCompany(company);
            bom.setItem(item);
            bom.setQty(bomDto.getQty());
            bom.setRate(bomDto.getRate());
            bom.setUsed(Math.toIntExact(bomDto.getUsed()));
            bom.setCreated(LocalDateTime.now());

            Bom insertBom = bomRepository.save(bom);
            Long uid = insertBom.getUid();
            CommonResultDto CommonResultDto = new CommonResultDto();


            List<Map<String, Object>> bomSubList = bomDto.getBom_data();

            if (bomSubList != null) {

                for (Map<String, Object> bomSubData : bomSubList) {

                    if (bomSubData.containsKey("title")) {

                        String title = (String) bomSubData.get("title");
                        if ("main".equals(title)) {

                            Bom subBom = new Bom();
                            subBom.setParent_uid(uid);
                            // item_uid 값이 있다면 item를 가져옴
                            if (bomSubData.containsKey("item_uid")) {
                                Long itemUid = Long.parseLong(bomSubData.get("item_uid").toString());
                                Item selectedItem = itemRepository.findByUid(itemUid);
                                subBom.setItem(selectedItem);
                            }
                            if (bomSubData.containsKey("company_uid")) {
                                Long companyUid = Long.parseLong(bomSubData.get("company_uid").toString());
                                Company selectedCompany = companyRepository.findByUid(companyUid);
                                subBom.setCompany(selectedCompany);
                            }
                            subBom.setCode(bomSubData.get("code").toString());
                            subBom.setQty(Double.valueOf(bomSubData.get("qty").toString()));
                            subBom.setRate(Double.valueOf(bomSubData.get("rate").toString()));
                            // product_uid 값이 있다면 product를 가져와서 userProduct에 설정

                            subBom.setCreated(LocalDateTime.now());
                            subBom.setUsed(1);


                            Bom insertSubBom = bomRepository.save(subBom);
                            Long sub_uid = insertSubBom.getUid();


                            if (bomSubData.containsKey("_children")) {
                                @SuppressWarnings("unchecked")
                                List<Map<String, Object>> children = (List<Map<String, Object>>) bomSubData.get("_children");
                                for (Map<String, Object> child : children) {

                                    Bom sub2Bom = new Bom();
                                    sub2Bom.setParent_uid(sub_uid);
                                    // item_uid 값이 있다면 item를 가져옴
                                    if (child.containsKey("item_uid")) {
                                        Long itemUid = Long.parseLong(child.get("item_uid").toString());
                                        Item selectedItem = itemRepository.findByUid(itemUid);
                                        sub2Bom.setItem(selectedItem);
                                    }
                                    if (child.containsKey("company_uid")) {
                                        Long companyUid = Long.parseLong(child.get("company_uid").toString());
                                        Company selectedCompany = companyRepository.findByUid(companyUid);
                                        sub2Bom.setCompany(selectedCompany);
                                    }
                                    sub2Bom.setCode(child.get("code").toString());
                                    sub2Bom.setQty(Double.valueOf(child.get("qty").toString()));
                                    sub2Bom.setRate(Double.valueOf(child.get("rate").toString()));
                                    // product_uid 값이 있다면 product를 가져와서 userProduct에 설정
                                    sub2Bom.setCreated(LocalDateTime.now());
                                    sub2Bom.setUsed(1);
                                    Bom insertSubBom2 = bomRepository.save(sub2Bom);
                                    Long sub2_uid = insertSubBom2.getUid();


                                    if (child.containsKey("_children")) {
                                        @SuppressWarnings("unchecked")
                                        List<Map<String, Object>> children2 = (List<Map<String, Object>>) child.get("_children");
                                        for (Map<String, Object> child2 : children2) {

                                            Bom sub3Bom = new Bom();
                                            sub3Bom.setParent_uid(sub2_uid);
                                            // item_uid 값이 있다면 item를 가져옴
                                            if (child2.containsKey("item_uid")) {
                                                Long itemUid = Long.parseLong(child2.get("item_uid").toString());
                                                Item selectedItem = itemRepository.findByUid(itemUid);
                                                sub3Bom.setItem(selectedItem);
                                            }
                                            if (child2.containsKey("company_uid")) {
                                                Long companyUid = Long.parseLong(child2.get("company_uid").toString());
                                                Company selectedCompany = companyRepository.findByUid(companyUid);
                                                sub3Bom.setCompany(selectedCompany);
                                            }
                                            sub3Bom.setCode(child2.get("code").toString());
                                            sub3Bom.setQty(Double.valueOf(child2.get("qty").toString()));
                                            sub3Bom.setRate(Double.valueOf(child2.get("rate").toString()));
                                            // product_uid 값이 있다면 product를 가져와서 userProduct에 설정
                                            sub3Bom.setCreated(LocalDateTime.now());
                                            sub3Bom.setUsed(1);
                                            bomRepository.save(sub3Bom);


                                        }
                                    }
                                }
                            }else{
                                setFailResult(CommonResultDto);
                                return CommonResultDto;
                            }



                        }

                    }



                }


                setSuccessResult(CommonResultDto);
                return CommonResultDto;

            }else {
                setFailResult(CommonResultDto);
                return CommonResultDto;

            }

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
