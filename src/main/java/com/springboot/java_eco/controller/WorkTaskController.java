package com.springboot.java_eco.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.data.dto.common.CommonInfoSearchDto;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.workTask.WorkTaskDto;
import com.springboot.java_eco.data.entity.WorkTask;
import com.springboot.java_eco.service.WorkTaskService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/work_task")
@Controller
public class WorkTaskController {
    private final WorkTaskService workTaskService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(WorkTaskController.class);

    @Autowired
    public WorkTaskController(WorkTaskService workTaskService){
        this.workTaskService = workTaskService;
    }

    @GetMapping(value= "/info_select")
    public ResponseEntity<List<WorkTask>> getWorkTask(@ModelAttribute CommonInfoSearchDto commonInfoSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<WorkTask> selectedWorkTask = workTaskService.getWorkTask(commonInfoSearchDto);

        LOGGER.info("[getTotalWorkTaskSub] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedWorkTask);

    }


    
    @GetMapping(value= "/select")
    public ResponseEntity<List<WorkTask>> getTotalWorkTask(@ModelAttribute CommonSearchDto commonSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<WorkTask> selectedTotalWorkTask = workTaskService.getTotalWorkTask(commonSearchDto);

        LOGGER.info("[getTotalWorkTask] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalWorkTask);

    }



    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public CommonResultDto createWorkTask(@RequestBody WorkTaskDto workTaskDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[workTaskDto]  : {}", workTaskDto);
        CommonResultDto workTaskResultDto = workTaskService.saveWorkTask(workTaskDto);
        LOGGER.info("[createWorkTask] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return  workTaskResultDto;

    }
    @PostMapping(value= "/update", consumes = "application/json", produces = "application/json")
    public CommonResultDto updateWorkTask(@RequestBody WorkTaskDto workTaskDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[workTaskDto]  : {}", workTaskDto);
        CommonResultDto workTaskResultDto = workTaskService.updateWorkTask(workTaskDto);
        LOGGER.info("[createWorkTask] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return  workTaskResultDto;

    }
    @PostMapping(value= "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteWorkTask(@RequestBody Map<String, List<Long>> requestMap) throws Exception {
        List<Long> uid = requestMap.get("uid");
        workTaskService.deleteWorkTask(uid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }


}
