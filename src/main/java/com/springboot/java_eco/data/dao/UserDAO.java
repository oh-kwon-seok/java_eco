package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.user.UserSearchDto;
import com.springboot.java_eco.data.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> selectTotalUser(UserSearchDto userSearchDto);

    List<User> selectUser(UserSearchDto userSearchDto);


}
