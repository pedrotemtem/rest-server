package com.appdetex.response;

import com.appdetex.entity.Detection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetectionResponse {

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
    public DetectionResponse(Detection detection) {
        this.id = detection.getId();
        this.orderOnPage = detection.getOrderOnPage();
        this.captureDate = detection.getCaptureDate();
        this.title = detection.getTitle();
        this.description = detection.getDescription();
        this.url = detection.getUrl();
        this.imageUrl = detection.getImageUrl();
        this.price = detection.getPrice();
        this.paidSearch = detection.getPaidSearch();
        this.seller = detection.getSeller();
        this.marketplace = detection.getMarketplace();
        this.status = detection.getStatus();
        this.state = detection.getState();
        this.reasonCode = detection.getReasonCode();
        this.accountId = detection.getAccountId();
        this.searchTerm = detection.getSearchTerm();
    }
}
