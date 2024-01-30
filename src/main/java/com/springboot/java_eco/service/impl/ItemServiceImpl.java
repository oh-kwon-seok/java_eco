package com.springboot.java_eco.service.impl;

import com.springboot.java_eco.data.dao.ItemDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.item.ItemDto;
import com.springboot.java_eco.data.entity.Item;
import com.springboot.java_eco.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemDAO ItemDAO;

    @Autowired
    public ItemServiceImpl(@Qualifier("itemDAOImpl") ItemDAO ItemDAO){
        this.ItemDAO = ItemDAO;
    }


    @Override
    public List<Item> getTotalItem(CommonSearchDto commonSearchDto){
        return ItemDAO.selectTotalItem(commonSearchDto);
    }

    @Override
    public Item saveItem(ItemDto ItemDto) throws Exception {

        return ItemDAO.insertItem(ItemDto);

    }
    @Override
    public Item updateItem(ItemDto ItemDto) throws Exception {
        return ItemDAO.updateItem(ItemDto);
    }
    @Override
    public void deleteItem(List<Long> uid) throws Exception {
        ItemDAO.deleteItem(uid);
    }

    @Override
    public void excelUploadItem(List<Map<String, Object>> requestList) throws Exception {
        ItemDAO.excelUploadItem(requestList);
    }

}
