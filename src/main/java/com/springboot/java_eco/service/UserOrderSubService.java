package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_eco.data.entity.UserOrderSub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserOrderSubService {

    List<UserOrderSub> getTotalUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> getTotalUserOrderSubHistory(UserOrderSubSearchDto userOrderSubSearchDto);


    List<UserOrderSub> getTotalMobileUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> getTotalMobileBuyUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);


    List<UserOrderSub> getUserOrderSub(UserOrderSubSearchDto userOrderSubSearchDto);



}
