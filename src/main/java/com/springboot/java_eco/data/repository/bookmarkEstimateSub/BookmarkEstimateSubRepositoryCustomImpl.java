package com.springboot.java_eco.data.repository.bookmarkEstimateSub;


import ch.qos.logback.classic.Logger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.springboot.java_eco.controller.BookmarkEstimateSubController;
import com.springboot.java_eco.data.dto.common.CommonInfoSearchDto;
import com.springboot.java_eco.data.entity.BookmarkEstimateSub;
import com.springboot.java_eco.data.entity.QBookmarkEstimateSub;
import com.springboot.java_eco.data.entity.QItem;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookmarkEstimateSubRepositoryCustomImpl extends QuerydslRepositorySupport implements BookmarkEstimateSubRepositoryCustom {

    public BookmarkEstimateSubRepositoryCustomImpl(){
        super(BookmarkEstimateSub.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(BookmarkEstimateSubController.class);

    
    @Override
    public List<BookmarkEstimateSub> findAll(CommonInfoSearchDto commonInfoSearchDto){
        QBookmarkEstimateSub bookmarkEstimateSub = QBookmarkEstimateSub.bookmarkEstimateSub;
        QItem item = QItem.item;

        String filter_title = commonInfoSearchDto.getFilter_title();
        String search_text = commonInfoSearchDto.getSearch_text();


        BooleanBuilder builder = new BooleanBuilder();


        if("all".equals(filter_title)){


            if (item.code != null) {
                builder.or(item.code.like("%" + search_text + "%"));
            }

        }else {

            if("code".equals(filter_title)){
                builder.and(item.code.like("%" + search_text + "%"));
            }
        }

        // used 필드가 1인 항목만 검색 조건 추가
        Predicate used = bookmarkEstimateSub.used.eq(1);


        Predicate predicate = builder.getValue();

        List<BookmarkEstimateSub> bookmarkEstimateSubList = from(bookmarkEstimateSub)
                .select(bookmarkEstimateSub)
                .where(predicate,used)
                .orderBy(bookmarkEstimateSub.created.desc()) // Order by created field in descending order
                .fetch();



        return bookmarkEstimateSubList;

    }

    @Override
    public List<BookmarkEstimateSub> findInfo(CommonInfoSearchDto commonSubSearchDto){

        QBookmarkEstimateSub bookmarkEstimateSub = QBookmarkEstimateSub.bookmarkEstimateSub;

        Predicate used = bookmarkEstimateSub.used.eq(1);

        List<BookmarkEstimateSub> bookmarkEstimateSubList = from(bookmarkEstimateSub)
                .select(bookmarkEstimateSub)
                .where(used)
                .fetch();

        return bookmarkEstimateSubList;

    }
}
