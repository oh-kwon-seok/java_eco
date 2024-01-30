package com.springboot.java_eco.data.dto.department;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@ToString

public class DepartmentDto {
    private Long uid;
    private String name;

    private Long used;
    private String token;

    public DepartmentDto(Long uid, String name, Long used, String token){
        this.uid = uid;
        this.name = name;

        this.used = used;
        this.token = token;

    }

}
