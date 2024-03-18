package com.springboot.java_eco.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.sensor.SensorDto;
import com.springboot.java_eco.data.dto.sensorRuntime.SensorRuntimeDto;
import com.springboot.java_eco.data.entity.Sensor;
import com.springboot.java_eco.data.entity.SensorRuntime;
import com.springboot.java_eco.service.SensorRuntimeService;
import com.springboot.java_eco.service.SensorService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor_runtime")
@Controller
public class SensorRuntimeController {
    private final SensorRuntimeService sensorRuntimeService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(SensorRuntimeController.class);

    @Autowired
    public SensorRuntimeController(SensorRuntimeService sensorRuntimeService){
        this.sensorRuntimeService = sensorRuntimeService;
    }

    @GetMapping(value= "/select")
    public ResponseEntity<List<SensorRuntime>> getTotalSensorRuntime(@ModelAttribute CommonSearchDto commonSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<SensorRuntime> selectedTotalSensorRuntime = sensorRuntimeService.getTotalSensorRuntime(commonSearchDto);

        LOGGER.info("[getTotalSensor] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalSensorRuntime);

    }
    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SensorRuntime> createSensorRuntime(@RequestBody SensorRuntimeDto sensorRuntimeDto
    ) throws Exception{
        long currentTime = System.currentTimeMillis();

        SensorRuntime sensorRuntime = sensorRuntimeService.saveSensorRuntime(sensorRuntimeDto);
        LOGGER.info("[createSensor] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return ResponseEntity.status(HttpStatus.OK).body(sensorRuntime);
    }
}
