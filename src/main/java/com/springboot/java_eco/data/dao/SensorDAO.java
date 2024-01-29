package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.sensor.SensorSearchDto;
import com.springboot.java_eco.data.entity.Sensor;

import java.util.List;


public interface SensorDAO {


    List<Sensor> selectTempSensor(SensorSearchDto SensorSearchDto);

    List<Sensor> selectHumiSensor(SensorSearchDto SensorSearchDto);


}
