package com.springboot.java_eco.data.repository.item;

import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.springboot.java_eco.controller.ItemController;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.*;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemRepositoryCustomImpl extends QuerydslRepositorySupport implements ItemRepositoryCustom {

    public ItemRepositoryCustomImpl(){
        super(Item.class);
    }
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ItemController.class);

    @Override
    public List<Item> findAll(CommonSearchDto commonSearchDto){
        QItem item = QItem.item;
        QCompany company = QCompany.company;
        String filter_title = commonSearchDto.getFilter_title();
        String search_text = commonSearchDto.getSearch_text();

        LocalDateTime start_date = commonSearchDto.getStart_date();
        LocalDateTime end_date = commonSearchDto.getEnd_date();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){
            if (item.name != null) {
                builder.or(item.name.like("%" + search_text + "%"));
            }
            if (item.type != null) {
                builder.or(item.type.like("%" + search_text + "%"));
            }

            if (item.company != null) {
                builder.or(company.name.like("%" + search_text + "%"));
            }

        }else {
            if("name".equals(filter_title)){
                builder.and(item.name.like("%" + search_text + "%"));
            }else if("company".equals(filter_title)){
                builder.and(company.name.like("%" + search_text + "%"));
            }
            else if("type".equals(filter_title)){
                builder.and(item.type.like("%" + search_text + "%"));
            }


        }
        Predicate dateRange = item.created.between(start_date, end_date);
        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = item.used.eq(1);
        Predicate predicate = builder.getValue();


        List<Tuple> results = from(item)
                .leftJoin(item.company, company).fetchJoin()
                .select(item,company)
                .where(predicate,dateRange,used)
                .orderBy(item.created.desc()) // Order by created field in descending order
                .fetch();
        List<Item> itemList = new ArrayList<>();

        for (Tuple result : results) {
            Item itemEntity = result.get(item);
            itemList.add(itemEntity);
            LOGGER.info("[Entity] data: {}", itemEntity);
        }

        return itemList;
    }


}