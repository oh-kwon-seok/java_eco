package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.SensorDAO;
import com.springboot.java_eco.data.dto.sensor.SensorSearchDto;
import com.springboot.java_eco.data.entity.Sensor;
import com.springboot.java_eco.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    private final SensorDAO sensorDAO;

    @Autowired
    public SensorServiceImpl(@Qualifier("sensorDAOImpl") SensorDAO sensorDAO){
        this.sensorDAO = sensorDAO;
    }


    @Override
    public List<Sensor> getTempSensor(SensorSearchDto sensorSearchDto){
        return sensorDAO.selectTempSensor(sensorSearchDto);
    }
    @Override
    public List<Sensor> getHumiSensor(SensorSearchDto sensorSearchDto){
        return sensorDAO.selectHumiSensor(sensorSearchDto);
    }



}
