package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.company.CompanyDto;
import com.springboot.java_eco.data.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CompanyService {

    List<Company> getTotalCompany(CommonSearchDto commonSearchDto);

    List<Company> getCompany(CommonSearchDto commonSearchDto);


    Company saveCompany(CompanyDto companyDto) throws Exception;

    Company updateCompany(CompanyDto companyDto) throws Exception;

    void deleteCompany(List<Long> uid) throws Exception;

    void excelUploadCompany(List<Map<String, Object>> requestList) throws Exception;


}
