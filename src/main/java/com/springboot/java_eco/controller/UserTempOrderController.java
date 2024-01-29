package com.springboot.java_eco.controller;


import ch.qos.logback.classic.Logger;
import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderDto;
import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderResultDto;
import com.springboot.java_eco.data.dto.userTempOrder.UserTempOrderSearchDto;
import com.springboot.java_eco.data.entity.UserTempOrder;
import com.springboot.java_eco.service.UserTempOrderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_temp_order")
@Controller
public class UserTempOrderController {
    private final UserTempOrderService userTempOrderService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserTempOrderController.class);

    @Autowired
    public UserTempOrderController(UserTempOrderService userTempOrderService){
        this.userTempOrderService = userTempOrderService;
    }

    @GetMapping(value= "/select")
    public ResponseEntity<List<UserTempOrder>> getTotalUserTempOrder(@ModelAttribute UserTempOrderSearchDto UserTempOrderSearchDto) throws RuntimeException{

        long currentTime = System.currentTimeMillis();

        List<UserTempOrder> selectedTotalUserTempOrder = userTempOrderService.getTotalUserTempOrder(UserTempOrderSearchDto);

        LOGGER.info("[getTotalUserTempOrder] response Time: {}ms,{}", System.currentTimeMillis() - currentTime);

        return ResponseEntity.status(HttpStatus.OK).body(selectedTotalUserTempOrder);

    }

    @PostMapping(value= "/save", consumes = "application/json", produces = "application/json")
    public UserTempOrderResultDto createUserTempOrder(@RequestBody UserTempOrderDto UserTempOrderDto) throws Exception{
        long currentTime = System.currentTimeMillis();
        LOGGER.info("[UserTempOrderDto]  : {}", UserTempOrderDto);
        UserTempOrderResultDto UserTempOrderResultDto = userTempOrderService.saveUserTempOrder(UserTempOrderDto);
        LOGGER.info("[createUserTempOrder] response Time : {}ms", System.currentTimeMillis() - currentTime);
        return  UserTempOrderResultDto;

    }
}
