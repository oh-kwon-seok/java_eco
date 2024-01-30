package com.springboot.java_eco.data.repository.department;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Department;
import com.springboot.java_eco.data.entity.QDepartment;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DepartmentRepositoryCustomImpl extends QuerydslRepositorySupport implements DepartmentRepositoryCustom {

    public DepartmentRepositoryCustomImpl(){
        super(Department.class);
    }

    @Override
    public List<Department> findAll(CommonSearchDto commonSearchDto){
        QDepartment department = QDepartment.department;

        String filter_title = commonSearchDto.getFilter_title();
        String search_text = commonSearchDto.getSearch_text();

        LocalDateTime start_date = commonSearchDto.getStart_date();
        LocalDateTime end_date = commonSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (department.name != null) {
                builder.or(department.name.like("%" + search_text + "%"));
            }
        }else {
            if("name".equals(filter_title)){
                builder.and(department.name.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = department.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = department.used.eq(1);

        List<Department> departmentList = from(department)
                .select(department)
                .where(used,dateRange)
                .fetch();

        return departmentList;
    }
    @Override
    public List<Department> findInfo(CommonSearchDto DepartmentSearchDto){

        QDepartment department = QDepartment.department;

        Predicate used = department.used.eq(1);

        List<Department> departmentList = from(department)
                .select(department)
                .where(used)
                .fetch();

        return departmentList;
    }




}
