package com.springboot.java_eco.data.repository.item;

import com.springboot.java_eco.data.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemRepositorySupport")
public interface ItemRepository extends JpaRepository<Item,Long>, ItemRepositoryCustom {



    Item findByCodeAndUsed(String code,Long used);



}
