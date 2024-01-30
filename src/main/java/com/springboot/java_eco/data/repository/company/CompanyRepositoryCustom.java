package com.springboot.java_eco.data.repository.company;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Company;

import java.util.List;

public interface CompanyRepositoryCustom {
    List<Company> findAll(CommonSearchDto commonSearchDto);
    List<Company> findInfo(CommonSearchDto commonSearchDto);

}
