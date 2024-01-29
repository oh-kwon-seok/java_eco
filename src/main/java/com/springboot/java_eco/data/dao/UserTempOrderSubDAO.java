package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_eco.data.entity.UserTempOrderSub;

import java.util.List;


public interface UserTempOrderSubDAO {


    List<UserTempOrderSub> selectTotalUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);
    List<UserTempOrderSub> selectTotalMobileUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> selectTotalMobileBuyUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);

    List<UserTempOrderSub> selectUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto);



}
