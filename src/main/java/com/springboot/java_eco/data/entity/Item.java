package com.springboot.java_eco.data.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="Item")
public class Item extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long uid;

    @Column(nullable = false)
    private String code; // 코드

    private String simple_code; // 약호

    private String ingr_kor_name; // 자재/제품 한글명

    private String ingr_eng_name; // 자재/제품 영문명

    private String inout_unit; // 수불단위

    private String inout_type; // 수불구분

    private String currency_unit; // 화폐단위

    private String buy_type; // 구매구분
    private String type_code; // 품목유형  // 원자재 / 부자재 / 반제품 / 완제품 등

    private String classify_code; // 유형코드

    private String component_code; // 성분코드

    private String hs_code; // hs코드

    private String nts_code; // 국세청 코드

    private String description; // 비고

    @ManyToOne
    @JoinColumn(name="type_uid")
    private Type type;

    @ManyToOne
    @JoinColumn(name="company_uid")
    private Company company;

    @Column(nullable = false)
    private Integer used;


}
