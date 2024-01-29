package com.springboot.java_eco.data.repository.UserOrderSub;

import com.springboot.java_eco.data.dto.userOrderSub.UserOrderSubSearchDto;
import com.springboot.java_eco.data.entity.UserOrderSub;

import java.util.List;

public interface UserOrderSubRepositoryCustom {



    List<UserOrderSub> findAll(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findAllHistory(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findMobileAll(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findMobileBuyAll(UserOrderSubSearchDto userOrderSubSearchDto);

    List<UserOrderSub> findInfo(UserOrderSubSearchDto userOrderSubSearchDto);

}
