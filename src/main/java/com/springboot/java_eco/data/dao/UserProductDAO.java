package com.springboot.java_eco.data.dao;


import com.springboot.java_eco.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_eco.data.entity.UserProduct;

import java.util.List;


public interface UserProductDAO {
    List<UserProduct> selectUserProduct(UserProductSearchDto userProductSearchDto);



}
