package com.springboot.java_eco.data.dao.impl;

import com.springboot.java_eco.data.dao.SensorDAO;
import com.springboot.java_eco.data.dto.sensor.SensorSearchDto;
import com.springboot.java_eco.data.entity.Sensor;
import com.springboot.java_eco.data.repository.sensor.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SensorDAOImpl implements SensorDAO {
    
    private final SensorRepository sensorRepository;
    @Autowired
    public SensorDAOImpl(SensorRepository sensorRepository){
        this.sensorRepository = sensorRepository;

    }

    @Override
    public List<Sensor> selectTempSensor(SensorSearchDto sensorSearchDto) {
        return sensorRepository.findTempAll(sensorSearchDto);

    }
    @Override
    public List<Sensor> selectHumiSensor(SensorSearchDto sensorSearchDto) {
        return sensorRepository.findHumiAll(sensorSearchDto);

    }
}
