package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.department.DepartmentDto;
import com.springboot.java_eco.data.entity.Department;

import java.util.List;


public interface DepartmentDAO {
    Department insertDepartment(DepartmentDto departmentDto);

    List<Department> selectTotalDepartment(CommonSearchDto commonSearchDto);
    List<Department> selectDepartment(CommonSearchDto departmentSearchDto);

    Department updateDepartment(DepartmentDto departmentDto) throws Exception;

    String deleteDepartment(List<Long> uid) throws Exception;


}
