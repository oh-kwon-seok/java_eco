package com.springboot.java_eco.data.repository.type;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Type;

import java.util.List;

public interface TypeRepositoryCustom {
    List<Type> findAll(CommonSearchDto typeSearchDto);
    List<Type> findInfo(CommonSearchDto typeSearchDto);

}
