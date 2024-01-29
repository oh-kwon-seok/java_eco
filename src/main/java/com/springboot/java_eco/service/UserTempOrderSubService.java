package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_eco.data.entity.UserTempOrderSub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserTempOrderSubService {

    List<UserTempOrderSub> getTotalUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> getTotalMobileUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);


    List<UserTempOrderSub> getUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);


    
}
