package com.springboot.java_eco.data.repository.UserTempOrderSub;

import com.springboot.java_eco.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_eco.data.entity.UserTempOrderSub;

import java.util.List;

public interface UserTempOrderSubRepositoryCustom {



    List<UserTempOrderSub> findAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto);
    List<UserTempOrderSub> findMobileAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> findMobileBuyAll(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> findInfo(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

}
