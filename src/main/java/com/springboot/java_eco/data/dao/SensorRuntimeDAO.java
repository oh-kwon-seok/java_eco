package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.sensorRuntime.SensorRuntimeDto;
import com.springboot.java_eco.data.entity.SensorRuntime;

import java.util.List;


public interface SensorRuntimeDAO {



    SensorRuntime insertSensorRuntime(SensorRuntimeDto sensorRuntimeDto) throws Exception;


    List<SensorRuntime> selectTotalSensorRuntime(CommonSearchDto commonSearchDto);




}
