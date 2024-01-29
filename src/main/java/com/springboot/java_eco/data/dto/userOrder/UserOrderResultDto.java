package com.springboot.java_eco.data.dto.userOrder;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserOrderResultDto {
    private boolean success;
    private int code;
    private String msg;


}