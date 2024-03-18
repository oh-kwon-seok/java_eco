package com.springboot.java_eco.data.dto;


import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SignInResultDto extends SignUpResultDto{
    private String token;

    @Builder
    public SignInResultDto(boolean success, int code, String msg, String token){
        super(success,code,msg);
        this.token = token;
    }

}
