package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class UpdateMarketplaceDetectionRequest {

    @Positive(message = "Detection ID is required")
    private Integer id;

    private Integer order_on_page;

    private String capture_date;

    private String title;

    private String description;

    private String url;

    private String image_url;

    private String price;

    private String paid_search;

    private String seller;

    private String marketplace;

    private String status;

    private String state;

    private String reason_code;

    private Integer analystId;

    private Integer account_id;

}