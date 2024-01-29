package com.springboot.java_eco.service;

import com.springboot.java_eco.data.dto.SignInResultDto;
import com.springboot.java_eco.data.dto.SignUpResultDto;
import com.springboot.java_eco.data.dto.user.UserDto;
import com.springboot.java_eco.data.dto.user.UserSearchDto;
import com.springboot.java_eco.data.entity.User;

import java.util.List;

public interface SignService {


    SignUpResultDto save(UserDto userDto);

    SignUpResultDto update(UserDto userDto);

    SignUpResultDto mobileUpdate(UserDto userDto);

    List<User> getTotalUser(UserSearchDto userSearchDto);
    List<User> getUser(UserSearchDto userSearchDto);

    String delete(List<String> id) throws Exception;
    SignInResultDto signIn(String userId, String password,String clientIp) throws RuntimeException;

    SignInResultDto passwordInit(String code, String phone) throws RuntimeException;


}
