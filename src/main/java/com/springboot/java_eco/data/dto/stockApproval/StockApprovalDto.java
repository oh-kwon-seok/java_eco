package com.springboot.java_eco.data.dto.stockApproval;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class StockApprovalDto {
    private Long uid;
    private String lot;

    private Long item_uid;
    private Long company_uid;
    private String user_id;
    private Long work_task_uid;
    private Long stock_request_uid;


    private Double out_qty;
    private String unit;
    private String status;
    private String token;



    public StockApprovalDto(
             Long uid,
             String lot,
             Long item_uid,
             Long company_uid,
             String user_id,
             Long work_task_uid,
             Long stock_request_uid,
             Double out_qty,
             String unit,
             String status,
             String token

    ){
        this.uid = uid;
        this.lot = lot;
        this.item_uid = item_uid;
        this.company_uid = company_uid;
        this.user_id = user_id;
        this.work_task_uid = work_task_uid;
        this.stock_request_uid = stock_request_uid;
        this.out_qty = out_qty;
        this.unit = unit;
        this.status = status;
        this.token = token;

    }

}
