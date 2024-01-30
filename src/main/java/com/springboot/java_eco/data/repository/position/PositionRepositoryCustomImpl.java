package com.springboot.java_eco.data.repository.position;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Position;
import com.springboot.java_eco.data.entity.QPosition;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PositionRepositoryCustomImpl extends QuerydslRepositorySupport implements PositionRepositoryCustom {

    public PositionRepositoryCustomImpl(){
        super(Position.class);
    }

    @Override
    public List<Position> findAll(CommonSearchDto commonSearchDto){
        QPosition position = QPosition.position;

        String filter_title = commonSearchDto.getFilter_title();
        String search_text = commonSearchDto.getSearch_text();

        LocalDateTime start_date = commonSearchDto.getStart_date();
        LocalDateTime end_date = commonSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){

            if (position.name != null) {
                builder.or(position.name.like("%" + search_text + "%"));
            }
            if (position.name2 != null) {
                builder.or(position.name2.like("%" + search_text + "%"));
            }

        }else {
            if("name".equals(filter_title)){
                builder.and(position.name.like("%" + search_text + "%"));
            }
            else if("name2".equals(filter_title)){
                builder.and(position.name2.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = position.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = position.used.eq(1);

        List<Position> positionList = from(position)
                .select(position)
                .where(used,dateRange)
                .fetch();

        return positionList;
    }
    @Override
    public List<Position> findInfo(CommonSearchDto commonSearchDto){

        QPosition position = QPosition.position;

        Predicate used = position.used.eq(1);

        List<Position> positionList = from(position)
                .select(position)
                .where(used)
                .fetch();

        return positionList;
    }




}
