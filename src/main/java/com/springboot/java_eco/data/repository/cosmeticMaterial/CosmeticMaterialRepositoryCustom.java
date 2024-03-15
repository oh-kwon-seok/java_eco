package com.springboot.java_eco.data.repository.cosmeticMaterial;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.CosmeticMaterial;

import java.util.List;

public interface CosmeticMaterialRepositoryCustom {
    List<CosmeticMaterial> findAll(CommonSearchDto commonSearchDto);
    List<CosmeticMaterial> findInfo(CommonSearchDto commonSearchDto);


}
