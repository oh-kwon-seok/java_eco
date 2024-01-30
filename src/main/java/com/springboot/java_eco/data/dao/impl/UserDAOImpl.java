package com.springboot.java_eco.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.data.dao.UserDAO;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.*;
import com.springboot.java_eco.data.repository.user.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserDAOImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> selectTotalUser(CommonSearchDto commonSearchDto) {
        return userRepository.findAll(commonSearchDto);
    }
    public List<User> selectUser(CommonSearchDto commonSearchDto) {
        return userRepository.findInfo(commonSearchDto);
    }
}

