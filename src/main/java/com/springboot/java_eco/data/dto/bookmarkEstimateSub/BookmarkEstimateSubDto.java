package com.springboot.java_eco.data.dto.bookmarkEstimateSub;

import lombok.*;

@Getter
@Setter

@Data
@NoArgsConstructor
@ToString

public class BookmarkEstimateSubDto {
    private Long uid;
    private Long bookmark_estimate_uid;
    private Long item_uid;

    private Double qty;
    private String unit;
    private Integer price;
    private Integer supply_price;
    private Integer vat_price;

    private Long used;
    private String token;


    public BookmarkEstimateSubDto(
                Long uid,
                Long bookmark_estimate_uid,
                Long item_uid,
                Double qty,

                String unit,
                Integer price,
                Integer supply_price,
                Integer vat_price,
                Long used,
                String token
    ){
        this.uid = uid;
        this.bookmark_estimate_uid = bookmark_estimate_uid;
        this.item_uid = item_uid;
        this.qty = qty;
        this.unit = unit;
        this.price = price;
        this.supply_price = supply_price;
        this.vat_price = vat_price;
        this.used = used;
        this.token = token;

    }

}
