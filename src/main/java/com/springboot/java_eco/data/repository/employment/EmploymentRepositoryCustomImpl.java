package com.springboot.java_eco.data.repository.employment;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Employment;
import com.springboot.java_eco.data.entity.QEmployment;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EmploymentRepositoryCustomImpl extends QuerydslRepositorySupport implements EmploymentRepositoryCustom {

    public EmploymentRepositoryCustomImpl(){
        super(Employment.class);
    }

    @Override
    public List<Employment> findAll(CommonSearchDto commonSearchDto){
        QEmployment employment = QEmployment.employment;

        String filter_title = commonSearchDto.getFilter_title();
        String search_text = commonSearchDto.getSearch_text();

        LocalDateTime start_date = commonSearchDto.getStart_date();
        LocalDateTime end_date = commonSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){

            if (employment.name != null) {
                builder.or(employment.name.like("%" + search_text + "%"));
            }
            if (employment.name2 != null) {
                builder.or(employment.name2.like("%" + search_text + "%"));
            } if (employment.company.name != null) {
                builder.or(employment.company.name.like("%" + search_text + "%"));
            }

        }else {
            if("name".equals(filter_title)){
                builder.and(employment.name.like("%" + search_text + "%"));
            }
            else if("name2".equals(filter_title)){
                builder.and(employment.name2.like("%" + search_text + "%"));
            } else if("company".equals(filter_title)){
                builder.and(employment.company.name.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = employment.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = employment.used.eq(1);

        List<Employment> employmentList = from(employment)
                .select(employment)
                .where(used,dateRange)
                .fetch();

        return employmentList;
    }
    @Override
    public List<Employment> findInfo(CommonSearchDto commonSearchDto){

        QEmployment employment = QEmployment.employment;

        Predicate used = employment.used.eq(1);

        List<Employment> employmentList = from(employment)
                .select(employment)
                .where(used)
                .fetch();

        return employmentList;
    }




}
