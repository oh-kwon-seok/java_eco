package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.common.CommonInfoSearchDto;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.workTask.WorkTaskDto;
import com.springboot.java_eco.data.entity.WorkTask;

import java.util.List;


public interface WorkTaskDAO {


    List<WorkTask> selectWorkTask(CommonInfoSearchDto commonInfoSearchDto);
    List<WorkTask> selectTotalWorkTask(CommonSearchDto commonSearchDto);

     CommonResultDto insertWorkTask(WorkTaskDto workTaskDto)  throws Exception;

    CommonResultDto updateWorkTask(WorkTaskDto workTaskDto)  throws Exception;
    String deleteWorkTask(List<Long> uid) throws Exception;



}
