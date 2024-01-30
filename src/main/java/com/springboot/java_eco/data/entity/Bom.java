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
@Table(name="bom")
public class Bom extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(nullable = false)
    private Long parent_uid;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name="item_uid")
    private Item item;



    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer used;


}
