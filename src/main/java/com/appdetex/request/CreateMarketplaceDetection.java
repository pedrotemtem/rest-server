package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class CreateMarketplaceDetection {

    @NotBlank(message = "Name can't be null")
    private String title;

    private String description;

    private String url;

    private String imageUrl;

    private String price;

    private String paidSearch;

    private Date date;

    private Integer marketplaceId;

    private Integer statusId;

    private Integer stateId;

    private Integer reasonCodesId;



}
