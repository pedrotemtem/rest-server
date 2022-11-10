package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateMarketplaceDetectionRequest {

    @NotNull
    private String title;

    private String description;

    @NotNull
    private String url;

    private String imageUrl;

    private String paidSearch;

    @NotNull
    private Integer orderOnPage;

    private String date;

    private String sellerName;

    @NotNull
    private Integer marketplaceId;

    @NotNull
    private Integer statusId;

    @NotNull
    private Integer stateId;

    private Integer reasonCodesId;

}
