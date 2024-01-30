package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.DepartmentDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.department.DepartmentDto;
import com.springboot.java_eco.data.entity.Department;
import com.springboot.java_eco.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentServiceImpl(@Qualifier("departmentDAOImpl") DepartmentDAO departmentDAO){
        this.departmentDAO = departmentDAO;
    }


    @Override
    public List<Department> getTotalDepartment(CommonSearchDto commonSearchDto){
        return departmentDAO.selectTotalDepartment(commonSearchDto);
    }

    @Override
    public List<Department> getDepartment(CommonSearchDto commonSearchDto){
        return departmentDAO.selectDepartment(commonSearchDto);
    }
    @Override
    public Department saveDepartment(DepartmentDto departmentDto) throws Exception {

        return departmentDAO.insertDepartment(departmentDto);

    }
    @Override
    public Department updateDepartment(DepartmentDto departmentDto) throws Exception {
        return departmentDAO.updateDepartment(departmentDto);
    }
    @Override
    public void deleteDepartment(List<Long> uid) throws Exception {
        departmentDAO.deleteDepartment(uid);
    }

}
