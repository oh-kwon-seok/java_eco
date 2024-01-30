package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.company.CompanyDto;
import com.springboot.java_eco.data.entity.Company;

import java.util.List;


public interface CompanyDAO {
    Company insertCompany(CompanyDto companyDto);

    List<Company> selectTotalCompany(CommonSearchDto CommonSearchDto);
    List<Company> selectCompany(CommonSearchDto companySearchDto);

    Company updateCompany(CompanyDto companyDto) throws Exception;

    String deleteCompany(List<Long> uid) throws Exception;


}
