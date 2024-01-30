package com.springboot.java_eco.data.dto.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResultDto {
    private boolean success;
    private int code;
    private String msg;


}