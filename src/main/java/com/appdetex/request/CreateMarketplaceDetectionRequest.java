package com.appdetex.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class CreateMarketplaceDetectionRequest {

    @NotBlank(message = "Name can't be null")
    private String title;

    private String description;

    private String url;

    private String imageUrl;

    private String price;

    private String paidSearch;

    @NotNull
    private Integer orderOnPage;

    private String date;

    @NotNull(message = "marketplace can't be null")
    @JsonProperty(value = "marketplace_id")
    private Integer marketplaceId;

    @NotNull
    private Integer statusId;

    @NotNull
    private Integer stateId;

    @NotNull
    private Integer reasonCodesId;

}
