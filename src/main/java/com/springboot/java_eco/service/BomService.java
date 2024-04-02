package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.bom.BomDto;
import com.springboot.java_eco.data.entity.Bom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BomService {

    List<Bom> getTotalBom(CommonSearchDto commonSearchDto);

    List<Bom> getBom(CommonSearchDto commonSearchDto);


    Bom saveBom(BomDto bomDto) throws Exception;

    Bom updateBom(BomDto bomDto) throws Exception;

    void deleteBom(List<Long> uid) throws Exception;

    //void excelUploadBom(List<Map<String, Object>> requestList) throws Exception;


}
