package com.springboot.java_eco.data.dto.position;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@ToString

public class PositionDto {
    private Long uid;
    private String name;
    private String name2;

    private Long used;
    private String token;

    public PositionDto(Long uid, String name, String name2, Long used, String token){
        this.uid = uid;
        this.name = name;
        this.name2 = name2;


        this.used = used;
        this.token = token;

    }

}
