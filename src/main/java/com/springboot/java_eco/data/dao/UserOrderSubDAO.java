package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.userOrderSub.UserOrderSubSearchDto;

import com.springboot.java_eco.data.entity.UserOrderSub;

import java.util.List;


public interface UserOrderSubDAO {


    List<UserOrderSub> selectTotalUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> selectTotalUserOrderSubHistory(UserOrderSubSearchDto userOrderSubSearchDto);


    List<UserOrderSub> selectTotalMobileUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> selectTotalMobileBuyUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> selectUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);



}