package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> selectTotalUser(CommonSearchDto userSearchDto);

    List<User> selectUser(CommonSearchDto userSearchDto);


}
