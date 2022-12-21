package com.appdetex.entity;

import com.appdetex.request.CreateDetectionRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "detections")
public class Detection {

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

    public Detection(CreateDetectionRequest createDetectionRequest) {
        this.id = createDetectionRequest.getId();
        this.orderOnPage = createDetectionRequest.getOrderOnPage();
        this.captureDate = createDetectionRequest.getCaptureDate();
        this.title = createDetectionRequest.getTitle();
        this.description = createDetectionRequest.getDescription();
        this.url = createDetectionRequest.getUrl();
        this.imageUrl = createDetectionRequest.getImageUrl();
        this.price = createDetectionRequest.getPrice();
        this.paidSearch = createDetectionRequest.getPaidSearch();
        this.seller = createDetectionRequest.getSeller();
        this.marketplace = createDetectionRequest.getMarketplace();
        this.status = createDetectionRequest.getStatus();
        this.state = createDetectionRequest.getState();
        this.reasonCode = createDetectionRequest.getReasonCode();
        this.accountId = createDetectionRequest.getAccountId();
        this.searchTerm = createDetectionRequest.getSearchTerm();
    }
}
