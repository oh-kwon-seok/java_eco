package com.springboot.java_eco.data.repository.user;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.User;

import java.util.List;

public interface UserRepositoryCustom {



    List<User> findAll(CommonSearchDto commonSearchDto);
    List<User> findInfo(CommonSearchDto commonSearchDto);



}
