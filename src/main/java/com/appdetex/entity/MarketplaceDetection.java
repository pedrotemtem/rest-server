package com.appdetex.entity;

import com.appdetex.request.CreateMarketplaceDetectionRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "marketplace_detections")
public class MarketplaceDetection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_on_page")
    private Integer order_on_page;

    @Column(name = "capture_date")
    private String capture_date;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "price")
    private String price;

    @Column(name = "paid_search")
    private String paid_search;

    @Column(name = "seller")
    private String seller;

    @Column(name = "marketplace")
    private String marketplace;

    @Column(name = "status")
    private String status;

    @Column(name = "state")
    private String state;

    @Column(name = "reason_code")
    private String reason_code;

    @Column(name = "account_id")
    private Integer accountId;

    public MarketplaceDetection(CreateMarketplaceDetectionRequest createMarketplaceDetectionRequest) {
        this.id = createMarketplaceDetectionRequest.getId();
        this.order_on_page = createMarketplaceDetectionRequest.getOrder_on_page();
        this.capture_date = createMarketplaceDetectionRequest.getCapture_date();
        this.title = createMarketplaceDetectionRequest.getTitle();
        this.description = createMarketplaceDetectionRequest.getDescription();
        this.url = createMarketplaceDetectionRequest.getUrl();
        this.image_url = createMarketplaceDetectionRequest.getImage_url();
        this.price = createMarketplaceDetectionRequest.getPrice();
        this.paid_search = createMarketplaceDetectionRequest.getPaid_search();
        this.seller = createMarketplaceDetectionRequest.getSeller();
        this.marketplace = createMarketplaceDetectionRequest.getMarketplace();
        this.status = createMarketplaceDetectionRequest.getStatus();
        this.state = createMarketplaceDetectionRequest.getState();
        this.reason_code = createMarketplaceDetectionRequest.getReason_code();
        this.accountId = createMarketplaceDetectionRequest.getAccount_id();
    }
}
