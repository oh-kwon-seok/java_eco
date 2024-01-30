package com.springboot.java_eco.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.data.dao.ItemDAO;
import com.springboot.java_eco.data.dto.common.CommonSearchDto;
import com.springboot.java_eco.data.dto.item.ItemDto;
import com.springboot.java_eco.data.entity.*;
import com.springboot.java_eco.data.repository.company.CompanyRepository;
import com.springboot.java_eco.data.repository.item.ItemRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ItemDAOImpl implements ItemDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ItemDAOImpl.class);

    private final ItemRepository itemRepository;
    private final CompanyRepository companyRepository;




    @Autowired
    public ItemDAOImpl(ItemRepository itemRepository,

                       CompanyRepository companyRepository) {
        this.itemRepository = itemRepository;

        this.companyRepository = companyRepository;
    }

    @Override
    public Item insertItem(ItemDto itemDto) throws Exception {

        Company company = companyRepository.findByUid(itemDto.getCompany_uid());


        Item item = new Item();

        item.setName(itemDto.getName());
        item.setType(itemDto.getType());
        item.setCompany(company);
        item.setUsed(Math.toIntExact(itemDto.getUsed()));

        item.setCreated(LocalDateTime.now());


        LOGGER.info("[item : ]: {}", item);


        Item insertItem = itemRepository.save(item);
        return insertItem;

    }

    @Override
    public List<Item> selectTotalItem(CommonSearchDto commonSearchDto) {
        return itemRepository.findAll(commonSearchDto);

    }

    @Override
    public Item updateItem(ItemDto itemDto) throws Exception {

        Company company = companyRepository.findByUid(itemDto.getCompany_uid());

        Optional<Item> selectedItem = itemRepository.findById(itemDto.getUid());

        Item updatedItem;

        if (selectedItem.isPresent()) {
            Item item = selectedItem.get();
            item.setName(itemDto.getName());
            item.setType(itemDto.getType());
            item.setCompany(company);
            item.setUsed(Math.toIntExact(itemDto.getUsed()));

            item.setUpdated(LocalDateTime.now());
            updatedItem = itemRepository.save(item);
        } else {
            throw new Exception();
        }
        return updatedItem;
    }

    @Override
    public String deleteItem(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<Item> selectedItem = itemRepository.findById(uid);
            if (selectedItem.isPresent()) {
                Item item = selectedItem.get();
                item.setUsed(0);
                item.setDeleted(LocalDateTime.now());
                itemRepository.save(item);
            } else {
                throw new Exception("Item with UID " + uid + " not found.");
            }
        }
        return "Items deleted successfully";
    }

    @Override
    public String excelUploadItem(List<Map<String, Object>> requestList) throws Exception {

        for (Map<String, Object> data : requestList) {
            String name = (String) data.get("name");
            String type = (String) data.get("type");

            // 예시로 이름과 수량이 모두 일치하는 Item를 찾는 메서드를 가정
            Optional<Item> selectedItem = Optional.ofNullable(itemRepository.findByNameAndType(name, type));

            if (selectedItem.isPresent()) {
                Item item = selectedItem.get();

                item.setName(name);
                item.setType(type);
                item.setUsed(1);
                item.setUpdated(LocalDateTime.now());
                itemRepository.save(item);
            } else {
                Item item = new Item();

                item.setName(name);
                item.setType(type);

                item.setUsed(1);

                item.setCreated(LocalDateTime.now());
                itemRepository.save(item);


            }
        }
        return "Items deleted successfully";
    }
}