package com.appdetex.response;

import com.appdetex.entity.MarketplaceDetection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarketplaceDetectionResponse {

    private Integer id;

    private Integer order_on_page;

    private String capture_date;

    private String title;

    private String description;

    private String url;

    private String image_url;

    private String price;

    private String paid_search;

    private String seller;

    private String marketplace;

    private String status;

    private String state;

    private String reason_code;

    public MarketplaceDetectionResponse(MarketplaceDetection marketplaceDetection) {
        this.id = marketplaceDetection.getId();
        this.order_on_page = marketplaceDetection.getOrder_on_page();
        this.capture_date = marketplaceDetection.getCapture_date();
        this.title = marketplaceDetection.getTitle();
        this.description = marketplaceDetection.getDescription();
        this.url = marketplaceDetection.getUrl();
        this.image_url = marketplaceDetection.getImage_url();
        this.price = marketplaceDetection.getPrice();
        this.paid_search = marketplaceDetection.getPaid_search();
        this.seller = marketplaceDetection.getSeller();
        this.marketplace = marketplaceDetection.getMarketplace();
        this.status = marketplaceDetection.getStatus();
        this.state = marketplaceDetection.getState();
        this.reason_code = marketplaceDetection.getReason_code();
    }
}
