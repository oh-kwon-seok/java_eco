package com.springboot.java_eco.data.repository.restricMaterialCountry;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;

import com.springboot.java_eco.data.entity.RestricMaterialCountry;

import java.util.List;

public interface RestricMaterialCountryRepositoryCustom {
    List<RestricMaterialCountry> findAll(CommonSearchDto commonSearchDto);
    List<RestricMaterialCountry> findInfo(CommonSearchDto commonSearchDto);


}
