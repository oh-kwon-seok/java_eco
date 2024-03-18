package com.springboot.java_eco.data.dto.sensorRuntime;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@ToString

public class SensorRuntimeDto {
    private Long uid;
    private String code;// DB 에 없는 컬럼

    private String type;

    private String token;

    public SensorRuntimeDto(Long uid,  String code,String type, String token){
        this.uid = uid;
        this.code = code;

        this.type = type;
        this.token = token;

    }

}
