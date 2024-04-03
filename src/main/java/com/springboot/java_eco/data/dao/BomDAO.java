package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.bom.BomDto;
import com.springboot.java_eco.data.entity.Bom;

import java.util.List;


public interface BomDAO {
    CommonResultDto insertBom(BomDto bomDto);

    List<Bom> selectTotalBom(CommonSearchDto commonSearchDto);
    List<Bom> selectBom(CommonSearchDto commonSearchDto);

    Bom updateBom(BomDto bomDto) throws Exception;

    String deleteBom(List<Long> uid) throws Exception;

    //String excelUploadBom(List<Map<String, Object>> requestList) throws Exception;


}
