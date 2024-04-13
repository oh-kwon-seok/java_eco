package com.springboot.java_eco.data.repository.bookmarkEstimateSub;

import com.springboot.java_eco.data.dto.common.CommonInfoSearchDto;

import com.springboot.java_eco.data.entity.BookmarkEstimateSub;

import java.util.List;

public interface BookmarkEstimateSubRepositoryCustom {


    List<BookmarkEstimateSub> findAll(CommonInfoSearchDto commonInfoSearchDto);
    List<BookmarkEstimateSub> findInfo(CommonInfoSearchDto commonInfoSearchDto);




}
