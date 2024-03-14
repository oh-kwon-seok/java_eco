package com.springboot.java_eco.data.repository.restricMaterial;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.RestricMaterial;

import java.util.List;

public interface RestricMaterialRepositoryCustom {
    List<RestricMaterial> findAll(CommonSearchDto commonSearchDto);
    List<RestricMaterial> findInfo(CommonSearchDto commonSearchDto);


}
