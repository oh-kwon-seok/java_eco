package com.springboot.java_eco.data.repository.sensorRuntime;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;

import com.springboot.java_eco.data.entity.QSensorRuntime;
import com.springboot.java_eco.data.entity.Sensor;
import com.springboot.java_eco.data.entity.SensorRuntime;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SensorRuntimeRepositoryCustomImpl extends QuerydslRepositorySupport implements SensorRuntimeRepositoryCustom {

    public SensorRuntimeRepositoryCustomImpl(){
        super(Sensor.class);
    }

    @Override
    public List<SensorRuntime> findAll(CommonSearchDto commonSearchDto){
        QSensorRuntime sensorRuntime = QSensorRuntime.sensorRuntime;

        String filter_title = commonSearchDto.getFilter_title();
        String search_text = commonSearchDto.getSearch_text();

        LocalDateTime start_date = commonSearchDto.getStart_date();
        LocalDateTime end_date = commonSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (sensorRuntime.code != null) {
                builder.or(sensorRuntime.code.like("%" + search_text + "%"));
            }
            if (sensorRuntime.type != null) {
                builder.or(sensorRuntime.type.like("%" + search_text + "%"));
            }
        }else {
            if("code".equals(filter_title)){
                builder.and(sensorRuntime.code.like("%" + search_text + "%"));
            }else if("type".equals(filter_title)){
                builder.and(sensorRuntime.type.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = sensorRuntime.created.between(start_date, end_date);


        List<SensorRuntime> sensorRuntimeList = from(sensorRuntime)
                .select(sensorRuntime)
                .where(dateRange)
                .fetch();

        return sensorRuntimeList;
    }





}
