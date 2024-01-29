package com.springboot.java_eco.data.repository.UserOrder;

import com.springboot.java_eco.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_eco.data.entity.UserOrder;

import java.util.List;

public interface UserOrderRepositoryCustom {


    List<UserOrder> findAllByDashboard(UserOrderSearchDto userOrderSearchDto);
    List<UserOrder> findAll(UserOrderSearchDto userOrderSearchDto);

    List<UserOrder> findAllByMobileTemp(UserOrderSearchDto userOrderSearchDto);


}
