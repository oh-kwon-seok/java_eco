package com.springboot.java_eco.data.repository.employment;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Employment;

import java.util.List;

public interface EmploymentRepositoryCustom {
    List<Employment> findAll(CommonSearchDto commonSearchDto);
    List<Employment> findInfo(CommonSearchDto commonSearchDto);

}
