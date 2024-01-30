package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.factory.FactoryDto;
import com.springboot.java_eco.data.entity.Factory;
import com.springboot.java_jangan.data.dto.factory.FactoryDto;
import com.springboot.java_jangan.data.dto.factory.CommonResultDto;
import com.springboot.java_jangan.data.dto.factory.CommonSearchDto;
import com.springboot.java_jangan.data.entity.Factory;

import java.util.List;


public interface FactoryDAO {


    List<Factory> selectFactory(CommonSearchDto commonSearchDto);
    List<Factory> selectTotalFactory(CommonSearchDto commonSearchDto);


     CommonResultDto insertFactory(FactoryDto factoryDto)  throws Exception;

    CommonResultDto updateFactory(FactoryDto factoryDto) throws Exception;


    String deleteFactory(List<Long> uid) throws Exception;


}
