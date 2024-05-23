package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.WorkTaskDAO;
import com.springboot.java_eco.data.dto.common.CommonInfoSearchDto;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;

import com.springboot.java_eco.data.dto.workTask.WorkTaskDto;
import com.springboot.java_eco.data.entity.WorkTask;
import com.springboot.java_eco.service.WorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTaskServiceImpl implements WorkTaskService {
    private final WorkTaskDAO workPlanDAO;

    @Autowired
    public WorkTaskServiceImpl(@Qualifier("workTaskDAOImpl") WorkTaskDAO workPlanDAO){
        this.workPlanDAO = workPlanDAO;
    }

    @Override
    public List<WorkTask> getWorkTask(CommonInfoSearchDto commonInfoSearchDto){
        return workPlanDAO.selectWorkTask(commonInfoSearchDto);
    }
    @Override
    public List<WorkTask> getTotalWorkTask(CommonSearchDto commonSearchDto){
        return workPlanDAO.selectTotalWorkTask(commonSearchDto);
    }
    @Override
    public CommonResultDto saveWorkTask(WorkTaskDto workPlanDto) throws Exception {

        return workPlanDAO.insertWorkTask(workPlanDto);

    }
    @Override
    public CommonResultDto updateWorkTask(WorkTaskDto workPlanDto) throws Exception {

        return workPlanDAO.updateWorkTask(workPlanDto);

    }

    @Override
    public void deleteWorkTask(List<Long> uid) throws Exception {
        workPlanDAO.deleteWorkTask(uid);
    }


}
