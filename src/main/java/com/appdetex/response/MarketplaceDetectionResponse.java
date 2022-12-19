package com.appdetex.response;

import com.appdetex.entity.MarketplaceDetection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketplaceDetectionResponse {

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

    private Integer accountId;

    private String searchTerm;

    public MarketplaceDetectionResponse(MarketplaceDetection marketplaceDetection) {
        this.id = marketplaceDetection.getId();
        this.orderOnPage = marketplaceDetection.getOrderOnPage();
        this.captureDate = marketplaceDetection.getCaptureDate();
        this.title = marketplaceDetection.getTitle();
        this.description = marketplaceDetection.getDescription();
        this.url = marketplaceDetection.getUrl();
        this.imageUrl = marketplaceDetection.getImageUrl();
        this.price = marketplaceDetection.getPrice();
        this.paidSearch = marketplaceDetection.getPaidSearch();
        this.seller = marketplaceDetection.getSeller();
        this.marketplace = marketplaceDetection.getMarketplace();
        this.status = marketplaceDetection.getStatus();
        this.state = marketplaceDetection.getState();
        this.reasonCode = marketplaceDetection.getReasonCode();
        this.accountId = marketplaceDetection.getAccountId();
        this.searchTerm = marketplaceDetection.getSearchTerm();
    }
}
