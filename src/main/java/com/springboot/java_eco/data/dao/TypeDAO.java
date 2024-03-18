package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.type.TypeDto;
import com.springboot.java_eco.data.entity.Type;

import java.util.List;


public interface TypeDAO {
    Type insertType(TypeDto typeDto);

    List<Type> selectTotalType(CommonSearchDto commonSearchDto);
    List<Type> selectType(CommonSearchDto typeSearchDto);

    Type updateType(TypeDto typeDto) throws Exception;

    String deleteType(List<Long> uid) throws Exception;


}
