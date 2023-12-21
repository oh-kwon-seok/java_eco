package com.springboot.java_jangan.data.dao.impl;

import ch.qos.logback.classic.Logger;
import com.springboot.java_jangan.common.CommonResponse;
import com.springboot.java_jangan.data.dao.UserOrderDAO;
import com.springboot.java_jangan.data.dto.SignInResultDto;
import com.springboot.java_jangan.data.dto.SignUpResultDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderResultDto;
import com.springboot.java_jangan.data.dto.userOrder.UserOrderSearchDto;
import com.springboot.java_jangan.data.entity.*;
import com.springboot.java_jangan.data.repository.User.UserRepository;
import com.springboot.java_jangan.data.repository.UserOrder.UserOrderRepository;
import com.springboot.java_jangan.data.repository.UserOrderSub.UserOrderSubRepository;
import com.springboot.java_jangan.data.repository.car.CarRepository;

import com.springboot.java_jangan.data.repository.product.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserOrderDAOImpl implements UserOrderDAO {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserOrderDAOImpl.class);

    private final UserOrderRepository userOrderRepository;
    private final UserOrderSubRepository userOrderSubRepository;

    private final UserRepository userRepository;


    private final CarRepository carRepository;
    private final ProductRepository productRepository;


    @Autowired
    public UserOrderDAOImpl(UserOrderRepository userOrderRepository,
                            UserOrderSubRepository userOrderSubRepository, UserRepository userRepository,
                            CarRepository carRepository,
                            ProductRepository productRepository) {
        this.userOrderRepository = userOrderRepository;
        this.userOrderSubRepository = userOrderSubRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.productRepository = productRepository;
    }

    @Override
    public UserOrderResultDto insertUserOrder(UserOrderDto userOrderDto) throws Exception {


        User user = userRepository.getById(String.valueOf(userOrderDto.getUser_id()));
        Car car = carRepository.findByUid(userOrderDto.getCar_uid());



        UserOrder userOrder = new UserOrder();

        userOrder.setOrder_status(String.valueOf(userOrderDto.getOrder_status()));
        userOrder.setPrice_status(String.valueOf(userOrderDto.getPrice_status()));
        userOrder.setUser(user);
        userOrder.setCar(car);
        userOrder.setUsed(Math.toIntExact(userOrderDto.getUsed()));
        userOrder.setCreated(LocalDateTime.now());

        UserOrder insertUserOrder = userOrderRepository.save(userOrder);

        Long uid = insertUserOrder.getUid();

        LOGGER.info("[uid] : {}",uid);
        UserOrder selectedUserOrder = userOrderRepository.findByUid(uid);

        List<Map<String, Object>> userOrderSubList = userOrderDto.getUser_order_sub();

        LOGGER.info("[UserOrder] : {}",selectedUserOrder);
        UserOrderResultDto UserOrderResultDto = new UserOrderResultDto();

        if (userOrderSubList != null) {

            for (Map<String, Object> userOrderSubData : userOrderSubList) {
                UserOrderSub userOrderSub = new UserOrderSub();
                userOrderSub.setUserOrder(selectedUserOrder);

                userOrderSub.setQty(Integer.parseInt(userOrderSubData.get("qty").toString()));

                userOrderSub.setPrice(Integer.parseInt(userOrderSubData.get("price").toString()));




                userOrderSub.setBuy_price(Integer.parseInt(userOrderSubData.get("buy_price").toString()));



                userOrderSub.setSupply_price(Integer.parseInt(userOrderSubData.get("supply_price").toString()));


                // product_uid 값이 있다면 product를 가져와서 userProduct에 설정
                if (userOrderSubData.containsKey("uid")) {
                    Long productUid = Long.parseLong(userOrderSubData.get("uid").toString());
                    Product product = productRepository.findById(productUid)
                            .orElseThrow(() -> new RuntimeException("Product not found for product_uid: " + productUid));
                    userOrderSub.setProduct(product);
                }
                userOrderSub.setCreated(LocalDateTime.now());
                userOrderSub.setUpdated(LocalDateTime.now());

                userOrderSubRepository.save(userOrderSub);
            }



            setSuccessResult(UserOrderResultDto);
            return UserOrderResultDto;

        }else {
            setFailResult(UserOrderResultDto);
            return UserOrderResultDto;

        }
    }


    @Override
    public UserOrderResultDto updateUserOrder(UserOrderDto userOrderDto) throws Exception {


        User user = userRepository.getById(String.valueOf(userOrderDto.getUser_id()));
        Car car = carRepository.findByUid(userOrderDto.getCar_uid());



        Optional<UserOrder> selectedUserOrder = userOrderRepository.findById(String.valueOf(userOrderDto.getUid()));

        UserOrder updatedUserOrder;

        if (selectedUserOrder.isPresent()) {
            UserOrder userOrder = selectedUserOrder.get();

            userOrder.setOrder_status(String.valueOf(userOrderDto.getOrder_status()));
            userOrder.setPrice_status(String.valueOf(userOrderDto.getPrice_status()));
            userOrder.setUser(user);
            userOrder.setCar(car);
            userOrder.setUsed(Math.toIntExact(userOrderDto.getUsed()));
            userOrder.setCreated(LocalDateTime.now());
            updatedUserOrder = userOrderRepository.save(userOrder);
        } else {
            throw new Exception();
        }


        List<Map<String, Object>> userOrderSubList = userOrderDto.getUser_order_sub();

        LOGGER.info("[UserOrder] : {}",selectedUserOrder);
        UserOrderResultDto UserOrderResultDto = new UserOrderResultDto();

        if (userOrderSubList != null) {

            List<UserOrderSub> deletedData = userOrderSubRepository.findByUserOrderUid(userOrderDto.getUid());
            userOrderSubRepository.deleteAll(deletedData);



            for (Map<String, Object> userOrderSubData : userOrderSubList) {
                UserOrderSub userOrderSub = new UserOrderSub();
                userOrderSub.setUserOrder(updatedUserOrder);
                userOrderSub.setQty(Integer.parseInt(userOrderSubData.get("qty").toString()));
                userOrderSub.setPrice(Integer.parseInt(userOrderSubData.get("price").toString()));
                userOrderSub.setBuy_price(Integer.parseInt(userOrderSubData.get("buy_price").toString()));
                userOrderSub.setSupply_price(Integer.parseInt(userOrderSubData.get("supply_price").toString()));

                // product_uid 값이 있다면 product를 가져와서 userProduct에 설정
                if (userOrderSubData.containsKey("uid")) {
                    Long productUid = Long.parseLong(userOrderSubData.get("uid").toString());
                    Product product = productRepository.findById(productUid)
                            .orElseThrow(() -> new RuntimeException("Product not found for product_uid: " + productUid));
                    userOrderSub.setProduct(product);
                }
                userOrderSub.setCreated(LocalDateTime.now());
                userOrderSub.setUpdated(LocalDateTime.now());

                userOrderSubRepository.save(userOrderSub);
            }



            setSuccessResult(UserOrderResultDto);
            return UserOrderResultDto;

        }else {
            setFailResult(UserOrderResultDto);
            return UserOrderResultDto;

        }
    }

    @Override
    public List<UserOrder> selectTotalUserOrder(UserOrderSearchDto userOrderSearchDto) {
        return userOrderRepository.findAll(userOrderSearchDto);

    }


    @Override
    public String deleteUserOrder(List<Long> uids) throws Exception {

        for (Long uid : uids) {
            Optional<UserOrder> selectedUserOrder = Optional.ofNullable(userOrderRepository.findByUid(uid));
            if (selectedUserOrder.isPresent()) {
                UserOrder userOrder = selectedUserOrder.get();
                userOrder.setUsed(0);
                userOrder.setDeleted(LocalDateTime.now());
                userOrderRepository.save(userOrder);
            } else {
                throw new Exception("UserOrder with UID " + uid + " not found.");
            }
        }
        return "UserOrders deleted successfully";
    }

    private void setSuccessResult(UserOrderResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailResult(UserOrderResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
    }

}