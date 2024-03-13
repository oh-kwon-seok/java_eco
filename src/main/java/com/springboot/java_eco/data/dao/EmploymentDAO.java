package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.employment.EmploymentDto;
import com.springboot.java_eco.data.entity.Employment;

import java.util.List;


public interface EmploymentDAO {
    Employment insertEmployment(EmploymentDto employmentDto);

    List<Employment> selectTotalEmployment(CommonSearchDto commonSearchDto);
    List<Employment> selectEmployment(CommonSearchDto commonSearchDto);

    Employment updateEmployment(EmploymentDto employmentDto) throws Exception;

    String deleteEmployment(List<Long> uid) throws Exception;


}
