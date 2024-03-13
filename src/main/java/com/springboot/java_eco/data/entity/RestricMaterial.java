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
@Table(name="restric_material")
public class RestricMaterial extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(nullable = false)
    private String regulate_type;

    @Column
    private String ingr_std_name;

    @Column
    private String ingr_eng_name;

    @Column
    private String cas_no;

    @Column
    private String ingr_synonym;

    @Column
    private String country_name;

    @Column
    private String notice_ingr_name;

    @Column
    private String provis_atrcl;

    @Column
    private String limit_cond;





    @Column(nullable = false)
    private Integer used;


}
