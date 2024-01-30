package com.springboot.java_eco.data.dao;

import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.item.ItemDto;
import com.springboot.java_eco.data.entity.Item;


import java.util.List;
import java.util.Map;


public interface ItemDAO {



    Item insertItem(ItemDto itemDto) throws Exception;


    List<Item> selectTotalItem(CommonSearchDto commonSearchDto);


    Item updateItem(ItemDto itemDto) throws Exception;

    String deleteItem(List<Long> uid) throws Exception;


    String excelUploadItem(List<Map<String, Object>> requestList) throws Exception;



}
