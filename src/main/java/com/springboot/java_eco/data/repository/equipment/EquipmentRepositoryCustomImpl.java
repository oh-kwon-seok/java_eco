package com.springboot.java_eco.data.repository.equipment;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Equipment;
import com.springboot.java_eco.data.entity.Equipment;
import com.springboot.java_eco.data.entity.QEquipment;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EquipmentRepositoryCustomImpl extends QuerydslRepositorySupport implements EquipmentRepositoryCustom {

    public EquipmentRepositoryCustomImpl(){
        super(Equipment.class);
    }

    @Override
    public List<Equipment> findAll(CommonSearchDto commonSearchDto){
        QEquipment equipment = QEquipment.equipment;

        String filter_title = commonSearchDto.getFilter_title();
        String search_text = commonSearchDto.getSearch_text();

        LocalDateTime start_date = commonSearchDto.getStart_date();
        LocalDateTime end_date = commonSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){

            if (equipment.name != null) {
                builder.or(equipment.name.like("%" + search_text + "%"));
            }
            if (equipment.purpose != null) {
                builder.or(equipment.purpose.like("%" + search_text + "%"));
            } if (equipment.company.name != null) {
                builder.or(equipment.company.name.like("%" + search_text + "%"));
            }if (equipment.description != null) {
                builder.or(equipment.description.like("%" + search_text + "%"));
            }

        }else {
            if("name".equals(filter_title)){
                builder.and(equipment.name.like("%" + search_text + "%"));
            }
            else if("purpose".equals(filter_title)){
                builder.and(equipment.purpose.like("%" + search_text + "%"));
            } else if("company".equals(filter_title)){
                builder.and(equipment.company.name.like("%" + search_text + "%"));
            }else if("description".equals(filter_title)){
                builder.and(equipment.description.like("%" + search_text + "%"));
            }
        }
        Predicate dateRange = equipment.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = equipment.used.eq(1);

        List<Equipment> equipmentList = from(equipment)
                .select(equipment)
                .where(used,dateRange)
                .fetch();

        return equipmentList;
    }
    @Override
    public List<Equipment> findInfo(CommonSearchDto commonSearchDto){

        QEquipment equipment = QEquipment.equipment;

        Predicate used = equipment.used.eq(1);

        List<Equipment> equipmentList = from(equipment)
                .select(equipment)
                .where(used)
                .fetch();

        return equipmentList;
    }




}
