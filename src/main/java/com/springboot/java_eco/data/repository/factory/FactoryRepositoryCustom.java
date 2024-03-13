package com.springboot.java_eco.data.repository.factory;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Factory;


import java.util.List;

public interface FactoryRepositoryCustom {


    List<Factory> findAll(CommonSearchDto commonSearchDto);
    List<Factory> findInfo(CommonSearchDto commonSearchDto);




}
