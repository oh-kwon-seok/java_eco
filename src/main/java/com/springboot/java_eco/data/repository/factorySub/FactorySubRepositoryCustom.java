package com.springboot.java_eco.data.repository.factorySub;

import com.springboot.java_eco.data.dto.factorySub.FactorySubSearchDto;
import com.springboot.java_eco.data.entity.FactorySub;


import java.util.List;

public interface FactorySubRepositoryCustom {



    List<FactorySub> findAll(FactorySubSearchDto factorySubSearchDto);


    List<FactorySub> findInfo(FactorySubSearchDto factorySubSearchDto);

}
