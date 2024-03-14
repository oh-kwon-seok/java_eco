package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.restricMaterial.RestricMaterialDto;
import com.springboot.java_eco.data.entity.RestricMaterial;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RestricMaterialService {

    List<RestricMaterial> getTotalRestricMaterial(CommonSearchDto commonSearchDto);

    List<RestricMaterial> getRestricMaterial(CommonSearchDto commonSearchDto);


    CommonResultDto saveRestricMaterial(RestricMaterialDto restricMaterialDto, String clientIp) throws Exception;

    void deleteRestricMaterial(List<Long> uid) throws Exception;




}
