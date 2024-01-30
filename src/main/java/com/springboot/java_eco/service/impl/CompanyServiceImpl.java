package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.CompanyDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.company.CompanyDto;
import com.springboot.java_eco.data.entity.Company;
import com.springboot.java_eco.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;

    @Autowired
    public CompanyServiceImpl(@Qualifier("companyDAOImpl") CompanyDAO companyDAO){
        this.companyDAO = companyDAO;
    }


    @Override
    public List<Company> getTotalCompany(CommonSearchDto commonSearchDto){
        return companyDAO.selectTotalCompany(commonSearchDto);
    }

    @Override
    public List<Company> getCompany(CommonSearchDto commonSearchDto){
        return companyDAO.selectCompany(commonSearchDto);
    }
    @Override
    public Company saveCompany(CompanyDto companyDto) throws Exception {

        return companyDAO.insertCompany(companyDto);

    }
    @Override
    public Company updateCompany(CompanyDto companyDto) throws Exception {
        return companyDAO.updateCompany(companyDto);
    }
    @Override
    public void deleteCompany(List<Long> uid) throws Exception {
        companyDAO.deleteCompany(uid);
    }

}
