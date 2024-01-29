package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.UserTempOrderSubDAO;
import com.springboot.java_eco.data.dto.userTempOrderSub.UserTempOrderSubSearchDto;
import com.springboot.java_eco.data.entity.UserTempOrderSub;
import com.springboot.java_eco.service.UserTempOrderSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTempOrderSubServiceImpl implements UserTempOrderSubService {
    private final UserTempOrderSubDAO userTempOrderSubDAO;

    @Autowired
    public UserTempOrderSubServiceImpl(@Qualifier("userTempOrderSubDAOImpl") UserTempOrderSubDAO userTempOrderSubDAO){
        this.userTempOrderSubDAO = userTempOrderSubDAO;
    }

    @Override
    public List<UserTempOrderSub> getTotalUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto){
        return userTempOrderSubDAO.selectTotalUserTempOrderSub(userTempOrderSubSearchDto);
    }
    @Override
    public List<UserTempOrderSub> getTotalMobileUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto){
        return userTempOrderSubDAO.selectTotalMobileUserTempOrderSub(userTempOrderSubSearchDto);
    }




    @Override
    public List<UserTempOrderSub> getUserTempOrderSub(UserTempOrderSubSearchDto userTempOrderSubSearchDto){
        return userTempOrderSubDAO.selectUserTempOrderSub(userTempOrderSubSearchDto);
    }


}
