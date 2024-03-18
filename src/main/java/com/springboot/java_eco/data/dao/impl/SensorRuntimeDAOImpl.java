package com.springboot.java_eco.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.data.dao.SensorRuntimeDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.sensorRuntime.SensorRuntimeDto;
import com.springboot.java_eco.data.entity.Company;
import com.springboot.java_eco.data.entity.SensorRuntime;
import com.springboot.java_eco.data.repository.sensorRuntime.SensorRuntimeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SensorRuntimeDAOImpl implements SensorRuntimeDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(SensorRuntimeDAOImpl.class);

    private final SensorRuntimeRepository sensorRuntimeRepository;


    @Autowired
    public SensorRuntimeDAOImpl(SensorRuntimeRepository sensorRuntimeRepository

                      ) {
        this.sensorRuntimeRepository = sensorRuntimeRepository;
    }

    @Override
    public SensorRuntime insertSensorRuntime(SensorRuntimeDto sensorRuntimeDto) throws Exception {


        SensorRuntime  sensorRuntime = new SensorRuntime();

        sensorRuntime.setCode(sensorRuntimeDto.getCode());
        sensorRuntime.setType(sensorRuntimeDto.getType());
        sensorRuntime.setCreated(LocalDateTime.now());

        SensorRuntime insertSensorRuntime = sensorRuntimeRepository.save(sensorRuntime);

        return insertSensorRuntime;

    }

    @Override
    public List<SensorRuntime> selectTotalSensorRuntime(CommonSearchDto commonSearchDto) {
        return sensorRuntimeRepository.findAll(commonSearchDto);

    }






}