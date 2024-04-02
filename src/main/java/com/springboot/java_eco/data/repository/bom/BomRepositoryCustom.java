package com.springboot.java_eco.data.repository.bom;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Bom;

import java.util.List;

public interface BomRepositoryCustom {
    List<Bom> findAll(CommonSearchDto commonSearchDto);
    List<Bom> findInfo(CommonSearchDto commonSearchDto);

}
