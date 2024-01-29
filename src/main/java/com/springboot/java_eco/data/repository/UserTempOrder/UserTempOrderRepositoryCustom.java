package com.springboot.java_eco.data.repository.UserTempOrder;

import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_eco.data.entity.UserTempOrder;

import java.util.List;

public interface UserTempOrderRepositoryCustom {



    List<UserTempOrder> findAll(UserTempOrderSearchDto userTempOrderSearchDto);


}
