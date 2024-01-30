package com.springboot.java_eco.data.dto.item;

import com.springboot.java_eco.data.entity.Company;
import lombok.*;


@Data
@NoArgsConstructor
@ToString

public class ItemDto {
    private Long uid;
    private String code;
    private String name;
    private String type;
    private Long company_uid;


    private Long used;
    private String token;

    public ItemDto(Long uid, String code, String name, String type, Long company_uid, Long used, String token){
        this.uid = uid;
        this.code = code;
        this.name = name;

        this.type = type;
        this.company_uid = company_uid;


        this.used = used;
        this.token = token;

    }

}
