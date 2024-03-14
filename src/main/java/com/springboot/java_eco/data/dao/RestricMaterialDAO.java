package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.restricMaterial.RestricMaterialDto;

import com.springboot.java_eco.data.entity.RestricMaterial;

import java.util.List;


public interface RestricMaterialDAO {



    CommonResultDto insertRestricMaterial(RestricMaterialDto restricMaterialDto,String clientIp) throws Exception;


    List<RestricMaterial> selectTotalRestricMaterial(CommonSearchDto commonSearchDto);

    List<RestricMaterial> selectRestricMaterial(CommonSearchDto commonSearchDto);


    String deleteRestricMaterial(List<Long> uid) throws Exception;






}
