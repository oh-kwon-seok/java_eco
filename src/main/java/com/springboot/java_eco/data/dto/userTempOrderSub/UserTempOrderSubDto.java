package com.springboot.java_eco.data.dto.userTempOrderSub;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class UserTempOrderSubDto {
    private Long uid;

    private String user_temp_order_uid;
    private Long product_uid;
    private Long car_uid;

    private Integer qty;
    private Integer price;
    private Integer buy_price;
    private Integer supply_price;

    private String token;

    public UserTempOrderSubDto(Long uid, String user_temp_order_uid, Long product_uid, Long car_uid, Integer qty, Integer price, Integer buy_price, Integer supply_price, String token){
        this.uid = uid;
        this.user_temp_order_uid = user_temp_order_uid;
        this.product_uid = product_uid;
        this.car_uid = car_uid;
        this.qty = qty;
        this.price = price;
        this.buy_price = buy_price;
        this.supply_price = supply_price;
        this.token = token;

    }

}
