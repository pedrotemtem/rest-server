package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateMarketplaceDetectionRequest {

    @NotNull(message = "id can't be null")
    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private String price;

    private String paidSearch;

    private Integer orderOnPage;

    private String date;

    private String sellerName;

    private String marketplaceId;

    private Integer statusId;

    private Integer stateId;

    private Integer reasonCodesId;


}
