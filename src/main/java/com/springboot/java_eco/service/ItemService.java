package com.springboot.java_eco.service;


import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.item.ItemDto;

import com.springboot.java_eco.data.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ItemService {

    List<Item> getTotalItem(CommonSearchDto commonSearchDto);

    Item saveItem(ItemDto ItemDto) throws Exception;

    Item updateItem(ItemDto ItemDto) throws Exception;

    void deleteItem(List<Long> uid) throws Exception;

    void excelUploadItem(List<Map<String, Object>> requestList) throws Exception;


}
