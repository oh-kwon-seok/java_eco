package com.springboot.java_eco.data.repository.department;

import com.springboot.java_eco.data.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("departmentRepositorySupport")
public interface DepartmentRepository extends JpaRepository<Department,Long>, DepartmentRepositoryCustom {

    Department findByUid(Long uid);
}
