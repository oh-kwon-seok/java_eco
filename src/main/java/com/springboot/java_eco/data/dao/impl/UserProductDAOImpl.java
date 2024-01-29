package com.springboot.java_eco.data.dao.impl;

import com.springboot.java_eco.data.dao.UserProductDAO;
import com.springboot.java_eco.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_eco.data.entity.UserProduct;
import com.springboot.java_eco.data.repository.UserProduct.UserProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserProductDAOImpl implements UserProductDAO {
    
    private final UserProductRepository userProductRepository;
    @Autowired
    public UserProductDAOImpl(UserProductRepository userProductRepository){
        this.userProductRepository = userProductRepository;

    }

    @Override
    public List<UserProduct> selectUserProduct(UserProductSearchDto userProductSearchDto) {
        return userProductRepository.findInfo(userProductSearchDto);

    }
}
