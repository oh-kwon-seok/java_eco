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
@Table(name="stock_approve")
public class StockApproval extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long uid;



    @ManyToOne
    @JoinColumn(name="item_uid")
    private Item item;

    @ManyToOne
    @JoinColumn(name="company_uid")
    private Company company;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="work_task_uid")
    private WorkTask workTask;

    @ManyToOne
    @JoinColumn(name="stock_request_uid")
    private StockRequest stockRequest;


    @Column(nullable = false)
    private Double out_qty; // 요청수량

    @Column
    private String unit; // 단위

    @Column(nullable = false)
    private String status;





}
