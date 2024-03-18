package com.springboot.java_eco.data.repository.sensorRuntime;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;

import com.springboot.java_eco.data.entity.SensorRuntime;

import java.util.List;

public interface SensorRuntimeRepositoryCustom {
    List<SensorRuntime> findAll(CommonSearchDto sensorSearchDto);


}
