package com.springboot.java_eco.data.dto.restricMaterial;

import jakarta.persistence.Column;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class RestricMaterialDto {

    private Long uid;

    private String regulate_type;
    private String ingr_std_name;
    private String ingr_eng_name;
    private String cas_no;
    private String ingr_synonym;
    private String country_name;
    private String notice_ingr_name;
    private String provis_atrcl;
    private String limit_cond;

    private Long used;
    private String token;

    public RestricMaterialDto(
                Long uid,
                String regulate_type,
                String ingr_std_name,
                String ingr_eng_name,
                String cas_no,
                String ingr_synonym,
                String country_name,
                String notice_ingr_name,
                String provis_atrcl,
                String limit_cond,
                Long used,
                String token
    ){
        this.uid = uid;
        this.regulate_type = regulate_type;
        this.ingr_std_name = ingr_std_name;
        this.ingr_eng_name = ingr_eng_name;
        this.cas_no = cas_no;
        this.ingr_synonym = ingr_synonym;
        this.country_name = country_name;
        this.notice_ingr_name = notice_ingr_name;
        this.provis_atrcl = provis_atrcl;
        this.limit_cond = limit_cond;
        this.used = used;
        this.token = token;

    }

}
