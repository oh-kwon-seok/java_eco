package com.springboot.java_eco.data.dto.factory;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class FactoryDto {

    private Long uid;


    private String name;
    private String status;
    private String description;
    private Long used;
    private String token;

    private List<Map<String, Object>> factory_sub;

    public FactoryDto(
                Long uid,
                String name,
                String status,
                String description,
                Long used,
                String token,
                List<Map<String, Object>> factory_sub
    ){
        this.uid = uid;
        this.name = name;
        this.status = status;
        this.description = description;
        this.used = used;
        this.token = token;
        this.factory_sub = factory_sub;
    }

}
