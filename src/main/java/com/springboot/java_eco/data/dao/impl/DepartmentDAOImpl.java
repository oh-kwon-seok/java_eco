package com.springboot.java_eco.data.dao.impl;

import com.springboot.java_eco.data.dao.DepartmentDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.department.DepartmentDto;
import com.springboot.java_eco.data.entity.Department;
import com.springboot.java_eco.data.repository.department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class DepartmentDAOImpl implements DepartmentDAO {
    
    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentDAOImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;

    }

    public Department insertDepartment(DepartmentDto departmentDto) {



        Department department = new Department();

        department.setName(departmentDto.getName());

        department.setUsed(Math.toIntExact(departmentDto.getUsed()));

        department.setCreated(LocalDateTime.now());

        Department insertDepartment = departmentRepository.save(department);
        return insertDepartment;

    }
    @Override
    public List<Department> selectTotalDepartment(CommonSearchDto commonSearchDto) {
        return departmentRepository.findAll(commonSearchDto);

    }

    @Override
    public List<Department> selectDepartment(CommonSearchDto commonSearchDto) {
        return departmentRepository.findInfo(commonSearchDto);

    }


    @Override
    public Department updateDepartment(DepartmentDto departmentDto) throws Exception {


        Optional<Department> selectedDepartment = departmentRepository.findById(departmentDto.getUid());

        Department updatedDepartment;

        if (selectedDepartment.isPresent()) {
            Department department = selectedDepartment.get();


            department.setName(departmentDto.getName());

            department.setUsed(Math.toIntExact(departmentDto.getUsed()));

            department.setUpdated(LocalDateTime.now());
            updatedDepartment = departmentRepository.save(department);
        } else {
            throw new Exception();
        }
        return updatedDepartment;
    }
    @Override
    public String deleteDepartment(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Department> selectedDepartment = departmentRepository.findById(uid);
            if (selectedDepartment.isPresent()) {
                Department department = selectedDepartment.get();
                department.setUsed(0);
                department.setDeleted(LocalDateTime.now());
                departmentRepository.save(department);
            } else {
                throw new Exception("Department with UID " + uid + " not found.");
            }
        }
        return "Departments deleted successfully";
    }
}
