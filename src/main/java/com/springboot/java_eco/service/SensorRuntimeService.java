package com.springboot.java_eco.service;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.sensorRuntime.SensorRuntimeDto;
import com.springboot.java_eco.data.entity.SensorRuntime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SensorRuntimeService {

    List<SensorRuntime> getTotalSensorRuntime(CommonSearchDto commonSearchDto);
    
    SensorRuntime saveSensorRuntime(SensorRuntimeDto sensorRuntimeDto) throws Exception;

    
}
