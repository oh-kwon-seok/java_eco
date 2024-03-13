package com.springboot.java_eco.service;



import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.factory.FactoryDto;
import com.springboot.java_eco.data.entity.Factory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FactoryService {

    List<Factory> getFactory(CommonSearchDto commonSearchDto);

    List<Factory> getTotalFactory(CommonSearchDto commonSearchDto);


    CommonResultDto saveFactory(FactoryDto factoryDto) throws Exception;

    CommonResultDto updateFactory(FactoryDto factoryDto) throws Exception;

    void deleteFactory(List<Long> uid) throws Exception;


}
