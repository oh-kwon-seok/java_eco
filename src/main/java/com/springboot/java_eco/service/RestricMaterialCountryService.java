package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;

import com.springboot.java_eco.data.dto.restricMaterialCountry.RestricMaterialCountryDto;

import com.springboot.java_eco.data.entity.RestricMaterialCountry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestricMaterialCountryService {

    List<RestricMaterialCountry> getTotalRestricMaterialCountry(CommonSearchDto commonSearchDto);

    List<RestricMaterialCountry> getRestricMaterialCountry(CommonSearchDto commonSearchDto);


    CommonResultDto saveRestricMaterialCountry(RestricMaterialCountryDto restricMaterialCountryDto, String clientIp) throws Exception;

    void deleteRestricMaterialCountry(List<Long> uid) throws Exception;




}
