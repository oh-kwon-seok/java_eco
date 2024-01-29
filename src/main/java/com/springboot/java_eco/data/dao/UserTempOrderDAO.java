package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderDto;
import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderResultDto;
import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_eco.data.entity.UserTempOrder;

import java.util.List;


public interface UserTempOrderDAO {


    List<UserTempOrder> selectTotalUserTempOrder(UserTempOrderSearchDto userTempOrderSearchDto);

     UserTempOrderResultDto insertUserTempOrder(UserTempOrderDto userTempOrderDto)  throws Exception;



}
