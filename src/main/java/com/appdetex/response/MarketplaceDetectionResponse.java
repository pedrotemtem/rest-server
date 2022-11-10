package com.appdetex.response;


import com.appdetex.entity.MarketplaceDetection;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;


@Getter
@Setter
public class MarketplaceDetectionResponse {

    private long id;

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



    public MarketplaceDetectionResponse(MarketplaceDetection marketplaceDetection) {
        this.id = marketplaceDetection.getId();
        this.title = marketplaceDetection.getTitle();
        this.description = marketplaceDetection.getDescription();
        this.url = marketplaceDetection.getUrl();
        this.imageUrl = marketplaceDetection.getImageUrl();
        this.price = marketplaceDetection.getPrice();
        this.paidSearch = marketplaceDetection.getPaidSearch();
        this.orderOnPage = marketplaceDetection.getOrderOnPage();
        this.date = marketplaceDetection.getDate();
        this.sellerName = marketplaceDetection.getSellerName();
        this.marketplaceId = marketplaceDetection.getMarketplaceId();
        this.statusId = marketplaceDetection.getStatusId();
        this.stateId = marketplaceDetection.getStateId();
        this.reasonCodesId = marketplaceDetection.getReasonCodesId();
    }
}
