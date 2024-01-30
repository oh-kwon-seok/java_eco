package com.springboot.java_eco.data.repository.department;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Department;

import java.util.List;

public interface DepartmentRepositoryCustom {
    List<Department> findAll(CommonSearchDto departmentSearchDto);
    List<Department> findInfo(CommonSearchDto departmentSearchDto);

}
