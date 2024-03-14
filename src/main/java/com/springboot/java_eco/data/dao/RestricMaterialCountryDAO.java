package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;

import com.springboot.java_eco.data.dto.restricMaterialCountry.RestricMaterialCountryDto;
import com.springboot.java_eco.data.entity.RestricMaterialCountry;

import java.util.List;


public interface RestricMaterialCountryDAO {



    CommonResultDto insertRestricMaterialCountry(RestricMaterialCountryDto restricMaterialDto, String clientIp) throws Exception;


    List<RestricMaterialCountry> selectTotalRestricMaterialCountry(CommonSearchDto commonSearchDto);

    List<RestricMaterialCountry> selectRestricMaterialCountry(CommonSearchDto commonSearchDto);


    String deleteRestricMaterialCountry(List<Long> uid) throws Exception;






}
