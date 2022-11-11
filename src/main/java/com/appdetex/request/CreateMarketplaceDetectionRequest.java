package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateMarketplaceDetectionRequest {

    private String title;

    private String description;

    private String url;

    private String imageUrl;

    private String price;

    private String paidSearch;

    private Integer orderOnPage;

    private String date;

    private String sellerName;

    private Integer marketplaceId;

    private Integer statusId;

    private Integer stateId;

    private Integer reasonCodesId;

}
