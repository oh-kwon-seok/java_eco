package com.springboot.java_eco.data.repository.item;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.entity.Item;

import java.util.List;

public interface ItemRepositoryCustom {
    List<Item> findAll(CommonSearchDto commonSearchDto);


}
