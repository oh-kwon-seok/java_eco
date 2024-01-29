package com.springboot.java_eco.data.repository.History;


import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.controller.ProductController;
import com.springboot.java_eco.data.entity.*;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

@Component
public class HistoryRepositoryCustomImpl extends QuerydslRepositorySupport implements HistoryRepositoryCustom {

    public HistoryRepositoryCustomImpl(){
        super(User.class);
    }

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductController.class);



}
