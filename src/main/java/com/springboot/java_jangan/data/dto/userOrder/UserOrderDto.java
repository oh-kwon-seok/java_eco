package com.springboot.java_jangan.data.dto.userOrder;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class UserOrderDto {

    private Long uid;
    private String user_id;
    private Long car_uid;

    private String order_status;
    private String price_status;
    private String description;

    private String image_url;
    private String ship_image_url;

    private String req_date;
    private String req_des;




    private Long used;
    private String token;


    private List<Map<String, Object>> user_product;
    private List<Map<String, Object>> user_order_sub;


    public UserOrderDto(
                Long uid,
                String user_id,
                Long car_uid,
                String order_status,
                String price_status,
                String description,

                String image_url,
                String ship_image_url,
                String req_date,
                String req_des,
                Long used,
                String token,

                List<Map<String, Object>> user_order_sub
    ){
        this.uid = uid;
        this.user_id = user_id;
        this.car_uid = car_uid;
        this.order_status = order_status;
        this.price_status = price_status;
        this.description = description;
        this.image_url = image_url;
        this.ship_image_url = ship_image_url;
        this.req_date = req_date;
        this.req_des = req_des;

        this.used = used;
        this.token = token;

        this.user_order_sub = user_order_sub;
    }

}
