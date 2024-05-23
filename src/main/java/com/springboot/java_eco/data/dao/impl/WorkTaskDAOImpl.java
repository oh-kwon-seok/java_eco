package com.springboot.java_eco.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.querydsl.core.Tuple;
import com.springboot.java_eco.common.CommonResponse;
import com.springboot.java_eco.data.dao.WorkTaskDAO;
import com.springboot.java_eco.data.dto.common.CommonInfoSearchDto;
import com.springboot.java_eco.data.dto.common.CommonResultDto;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.workTask.WorkTaskDto;
import com.springboot.java_eco.data.entity.*;
import com.springboot.java_eco.data.repository.bom.BomRepository;
import com.springboot.java_eco.data.repository.company.CompanyRepository;
import com.springboot.java_eco.data.repository.stockRequest.StockRequestRepository;
import com.springboot.java_eco.data.repository.user.UserRepository;
import com.springboot.java_eco.data.repository.workPlan.WorkPlanRepository;
import com.springboot.java_eco.data.repository.workTask.WorkTaskRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class WorkTaskDAOImpl implements WorkTaskDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(WorkTaskDAOImpl.class);

    private final WorkTaskRepository workTaskRepository;
    private final WorkPlanRepository workPlanRepository;
    private final StockRequestRepository stockRequestRepository;

    private final UserRepository userRepository;

    private final BomRepository bomRepository;

    private final CompanyRepository companyRepository;

    @Autowired
    public WorkTaskDAOImpl(WorkTaskRepository workTaskRepository,
                           WorkPlanRepository workPlanRepository,
                           StockRequestRepository stockRequestRepository,
                           BomRepository bomRepository,
                           CompanyRepository companyRepository,
                           UserRepository userRepository

                          ) {
        this.workTaskRepository = workTaskRepository;
        this.workPlanRepository = workPlanRepository;
        this.userRepository = userRepository;
        this.stockRequestRepository = stockRequestRepository;
        this.bomRepository = bomRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public CommonResultDto insertWorkTask(WorkTaskDto workTaskDto) throws Exception {
        WorkPlan workPlan = workPlanRepository.findByUid(workTaskDto.getWork_plan_uid());
        Company company = companyRepository.findByUid(workTaskDto.getCompany_uid());
        Bom bom = bomRepository.findByUid(workTaskDto.getBom_uid());
        User user = userRepository.getById(workTaskDto.getUser_id());

        WorkTask workTask = new WorkTask();

        workTask.setBom(bom);
        workTask.setCompany(company);
        workTask.setWorkPlan(workPlan);
        workTask.setUser(user);

        workTask.setTask_qty(workTaskDto.getTask_qty());
        workTask.setSuccess_qty(0D);
        workTask.setFail_qty(0D);
        workTask.setWork_start_date(workTaskDto.getWork_start_date());
        workTask.setWork_end_date(workTaskDto.getWork_start_date());
        workTask.setMaterial_order(1L);
        workTask.setMeasure_order(0L);
        workTask.setProduction_order(0L);
        workTask.setPacking_order(0L);




        workTask.setUnit(workTaskDto.getUnit());
        workTask.setStatus("준비");

        workTask.setCreated(LocalDateTime.now());

        WorkTask insertWorkTask = workTaskRepository.save(workTask);

        Long uid = insertWorkTask.getUid();
        CommonResultDto CommonResultDto = new CommonResultDto();

        if(uid != null){
            // 제조지시에 맞는 BOM 자재를 검색해서 save 해야함
            List<Bom> selectedBom = bomRepository.findByMain(bom.getMain());

            if(selectedBom != null && !selectedBom.isEmpty()){
                for(Bom insertBom :selectedBom){
                    StockRequest stockRequest = new StockRequest();
                    stockRequest.setItem(insertBom.getItem());
                    stockRequest.setCompany(company);
                    stockRequest.setUser(user);
                    stockRequest.setWorkTask(workTask);
                    stockRequest.setReq_qty(workTask.getTask_qty() * insertBom.getQty());
                    stockRequest.setUnit(insertBom.getItem().getInout_unit());

                    stockRequest.setStatus("요청");
                    stockRequest.setCreated(LocalDateTime.now());
                    StockRequest insertStockRequest = stockRequestRepository.save(stockRequest);
                    Long stockRequestUid = insertStockRequest.getUid();
                    if(stockRequestUid == null) {
                        setFailResult(CommonResultDto);
                        return CommonResultDto;
                    }
                }

            }

            setSuccessResult(CommonResultDto);
            return CommonResultDto;


            }else{
                setFailResult(CommonResultDto);
                return CommonResultDto;
            }
    }

    @Override
    public CommonResultDto updateWorkTask(WorkTaskDto workTaskDto) throws Exception {

        Company company = companyRepository.findByUid(workTaskDto.getCompany_uid());
        Bom bom = bomRepository.findByUid(workTaskDto.getBom_uid());
        WorkPlan workPlan = workPlanRepository.findByUid(workTaskDto.getWork_plan_uid());


        Optional<WorkTask> selectedWorkTask = workTaskRepository.findById(workTaskDto.getUid());

        WorkTask updatedWorkTask;
        CommonResultDto CommonResultDto = new CommonResultDto();
        if (selectedWorkTask.isPresent()) {
            WorkTask workTask = selectedWorkTask.get();
            workTask.setBom(bom);

            workTask.setCompany(company);
            workTask.setWorkPlan(workPlan);

            workTask.setTask_qty(workTaskDto.getTask_qty());
            workTask.setSuccess_qty(workTaskDto.getSuccess_qty());
            workTask.setFail_qty(workTaskDto.getFail_qty());
            workTask.setWork_start_date(workTaskDto.getWork_start_date());
            workTask.setWork_end_date(workTaskDto.getWork_start_date());
            workTask.setMaterial_order(workTaskDto.getMaterial_order());
            workTask.setUnit(workTaskDto.getUnit());
            workTask.setStatus("준비");

            workTask.setCreated(LocalDateTime.now());

            workTask.setUpdated(LocalDateTime.now());
            updatedWorkTask = workTaskRepository.save(workTask);

            Long uid = updatedWorkTask.getUid();

            setSuccessResult(CommonResultDto);
            return CommonResultDto;

        } else {

            setFailResult(CommonResultDto);
            return CommonResultDto;
        }

    }



    @Override
    public List<WorkTask> selectWorkTask(CommonInfoSearchDto commonInfoSearchDto) {
        return workTaskRepository.findInfo(commonInfoSearchDto);

    }

    @Override
    public List<WorkTask> selectTotalWorkTask(CommonSearchDto commonSearchDto) {
        return workTaskRepository.findAll(commonSearchDto);

    }

    @Override
    public String deleteWorkTask(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<WorkTask> selectedWorkTask = Optional.ofNullable(workTaskRepository.findByUid(uid));
            if (selectedWorkTask.isPresent()) {
                WorkTask workTask = selectedWorkTask.get();

                workTaskRepository.delete(workTask);
            } else {
                throw new Exception("WORKPLAN with UID " + uid + " not found.");
            }
        }
        return "WORKPLAN deleted successfully";
    }


    private void setSuccessResult(CommonResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(CommonResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }

}