package com.springboot.java_eco.data.dto.stockInout;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class StockInoutDto {
    private Long uid;
    private String code;
    private Long doc_uid;
    private Long doc_type;
    private String status;

    private Long company_uid;
    private Long user_id;
    private String token;


    public StockInoutDto(
             Long uid,
            String code,
            Long doc_uid,
            Long doc_type,
            String status,
            Long company_uid,
            Long user_id,
            String token
    ){
        this.uid = uid;
        this.code = code;
        this.doc_uid = doc_uid;
        this.doc_type = doc_type;
        this.status = status;
        this.company_uid = company_uid;
        this.user_id = user_id;
        this.token = token;

    }

}
