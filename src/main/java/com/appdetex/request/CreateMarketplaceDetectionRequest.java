package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateMarketplaceDetectionRequest {

    private Integer id;
    private Integer orderOnPage;
    private String captureDate;
    private String title;
    private String description;
    private String url;
    private String imageUrl;
    private String price;
    private String paidSearch;
    private String seller;
    private String marketplace;
    private String state;
    private String status;
    private String reasonCode;
    private Integer accountId;
    private String searchTerm;
}