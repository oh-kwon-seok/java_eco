package com.springboot.java_eco.data.repository.company;

import com.springboot.java_eco.data.dto.company.CompanySearchDto;
import com.springboot.java_eco.data.entity.Company;

import java.util.List;

public interface CompanyRepositoryCustom {
    List<Company> findAll(CompanySearchDto companySearchDto);
    List<Company> findInfo(CompanySearchDto companySearchDto);

}
