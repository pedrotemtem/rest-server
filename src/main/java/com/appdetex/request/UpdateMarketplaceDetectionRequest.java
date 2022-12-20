package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class UpdateMarketplaceDetectionRequest {

    @Positive(message = "Detection ID is required")
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
    private String status;
    private String state;
    private String reasonCode;
    private Integer analystId;
    private Integer accountId;
    private String searchTerm;
}