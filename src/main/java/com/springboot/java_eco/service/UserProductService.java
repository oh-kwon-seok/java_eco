package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_eco.data.entity.UserProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProductService {
    
    List<UserProduct> getUserProduct(UserProductSearchDto userProductSearchDto);



}
