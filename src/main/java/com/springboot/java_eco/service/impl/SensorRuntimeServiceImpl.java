package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.SensorRuntimeDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;

import com.springboot.java_eco.data.dto.sensorRuntime.SensorRuntimeDto;
import com.springboot.java_eco.data.entity.SensorRuntime;
import com.springboot.java_eco.service.SensorRuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorRuntimeServiceImpl implements SensorRuntimeService {
    private final SensorRuntimeDAO SensorRuntimeDAO;

    @Autowired
    public SensorRuntimeServiceImpl(@Qualifier("sensorRuntimeDAOImpl") SensorRuntimeDAO SensorRuntimeDAO){
        this.SensorRuntimeDAO = SensorRuntimeDAO;
    }


    @Override
    public List<SensorRuntime> getTotalSensorRuntime(CommonSearchDto commonSearchDto){
        return SensorRuntimeDAO.selectTotalSensorRuntime(commonSearchDto);
    }

    @Override
    public SensorRuntime saveSensorRuntime(SensorRuntimeDto SensorRuntimeDto) throws Exception {

        return SensorRuntimeDAO.insertSensorRuntime(SensorRuntimeDto);

    }
}
