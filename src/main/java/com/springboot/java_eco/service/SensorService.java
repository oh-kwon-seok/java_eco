package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.sensor.SensorSearchDto;
import com.springboot.java_eco.data.entity.Sensor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SensorService {

    List<Sensor> getTempSensor(SensorSearchDto sensorSearchDto);
    List<Sensor> getHumiSensor(SensorSearchDto sensorSearchDto);


}
