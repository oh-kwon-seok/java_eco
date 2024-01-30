package com.springboot.java_eco.data.dao.impl;

import com.springboot.java_eco.data.dao.CompanyDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.company.CompanyDto;
import com.springboot.java_eco.data.entity.Company;
import com.springboot.java_eco.data.repository.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CompanyDAOImpl implements CompanyDAO {
    
    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyDAOImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;

    }

    public Company insertCompany(CompanyDto companyDto) {



        Company company = new Company();
        company.setCode(companyDto.getCode());

        company.setName(companyDto.getName());
        company.setEmail(companyDto.getEmail());
        company.setPhone(companyDto.getPhone());

        company.setUsed(Math.toIntExact(companyDto.getUsed()));

        company.setCreated(LocalDateTime.now());

        Company insertCompany = companyRepository.save(company);
        return insertCompany;

    }
    @Override
    public List<Company> selectTotalCompany(CommonSearchDto commonSearchDto) {
        return companyRepository.findAll(commonSearchDto);

    }

    @Override
    public List<Company> selectCompany(CommonSearchDto commonSearchDto) {
        return companyRepository.findInfo(commonSearchDto);

    }


    @Override
    public Company updateCompany(CompanyDto companyDto) throws Exception {


        Optional<Company> selectedCompany = companyRepository.findById(companyDto.getUid());

        Company updatedCompany;

        if (selectedCompany.isPresent()) {
            Company company = selectedCompany.get();

            company.setCode(companyDto.getCode());
            company.setName(companyDto.getName());
            company.setEmail(companyDto.getEmail());
            company.setPhone(companyDto.getPhone());
            company.setUsed(Math.toIntExact(companyDto.getUsed()));

            company.setUpdated(LocalDateTime.now());
            updatedCompany = companyRepository.save(company);
        } else {
            throw new Exception();
        }
        return updatedCompany;
    }
    @Override
    public String deleteCompany(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Company> selectedCompany = companyRepository.findById(uid);
            if (selectedCompany.isPresent()) {
                Company company = selectedCompany.get();
                company.setUsed(0);
                company.setDeleted(LocalDateTime.now());
                companyRepository.save(company);
            } else {
                throw new Exception("Company with UID " + uid + " not found.");
            }
        }
        return "Companys deleted successfully";
    }
}
