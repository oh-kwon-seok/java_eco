package com.springboot.java_eco.data.repository.UserProduct;

import com.springboot.java_eco.data.dto.userProduct.UserProductSearchDto;
import com.springboot.java_eco.data.entity.UserProduct;

import java.util.List;

public interface UserProductRepositoryCustom {


    List<UserProduct> findInfo(UserProductSearchDto userProductSearchDto);

}
