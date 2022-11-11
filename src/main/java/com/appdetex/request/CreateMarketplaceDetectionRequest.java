package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateMarketplaceDetectionRequest {

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

    private String state;

    private String status;

    private String reason_code;

}