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
    private Integer orderOnPage;

    @Column(name = "capture_date")
    private String captureDate;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "price")
    private String price;

    @Column(name = "paid_search")
    private String paidSearch;

    @Column(name = "seller")
    private String seller;

    @Column(name = "marketplace")
    private String marketplace;

    @Column(name = "status")
    private String status;

    @Column(name = "state")
    private String state;

    @Column(name = "reason_code")
    private String reasonCode;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "search_term")
    private String searchTerm;

    public MarketplaceDetection(CreateMarketplaceDetectionRequest createMarketplaceDetectionRequest) {
        this.id = createMarketplaceDetectionRequest.getId();
        this.orderOnPage = createMarketplaceDetectionRequest.getOrderOnPage();
        this.captureDate = createMarketplaceDetectionRequest.getCaptureDate();
        this.title = createMarketplaceDetectionRequest.getTitle();
        this.description = createMarketplaceDetectionRequest.getDescription();
        this.url = createMarketplaceDetectionRequest.getUrl();
        this.imageUrl = createMarketplaceDetectionRequest.getImageUrl();
        this.price = createMarketplaceDetectionRequest.getPrice();
        this.paidSearch = createMarketplaceDetectionRequest.getPaidSearch();
        this.seller = createMarketplaceDetectionRequest.getSeller();
        this.marketplace = createMarketplaceDetectionRequest.getMarketplace();
        this.status = createMarketplaceDetectionRequest.getStatus();
        this.state = createMarketplaceDetectionRequest.getState();
        this.reasonCode = createMarketplaceDetectionRequest.getReasonCode();
        this.accountId = createMarketplaceDetectionRequest.getAccountId();
        this.searchTerm = createMarketplaceDetectionRequest.getSearchTerm();
    }
}
