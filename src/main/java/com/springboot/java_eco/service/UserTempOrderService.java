package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderDto;
import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderResultDto;
import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_eco.data.entity.UserTempOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserTempOrderService {

    List<UserTempOrder> getTotalUserTempOrder(UserTempOrderSearchDto UserTempOrderSearchDto);


    UserTempOrderResultDto saveUserTempOrder(UserTempOrderDto UserTempOrderDto) throws Exception;



}
