package com.appdetex.entity;
import com.appdetex.request.CreateMarketplaceDetectionRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "marketplace_detections")
@NoArgsConstructor
public class MarketplaceDetection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="title")
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

    @Column(name ="order_on_page")
    private Integer orderOnPage;

    @Column(name = "date")
    private String date;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "marketplace_id")
    private Integer marketplaceId;

    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "reason_codes_id")
    private Integer reasonCodesId;


    public MarketplaceDetection(CreateMarketplaceDetectionRequest createMarketplaceDetectionRequest) {
        this.title = createMarketplaceDetectionRequest.getTitle();
        this.description = createMarketplaceDetectionRequest.getDescription();
        this.url = createMarketplaceDetectionRequest.getUrl();
        this.imageUrl = createMarketplaceDetectionRequest.getImageUrl();
        this.price = createMarketplaceDetectionRequest.getPrice();
        this.paidSearch = createMarketplaceDetectionRequest.getPaidSearch();
        this.orderOnPage = createMarketplaceDetectionRequest.getOrderOnPage();
        this.date = createMarketplaceDetectionRequest.getDate();
        this.sellerName = createMarketplaceDetectionRequest.getSellerName();
        this.marketplaceId = createMarketplaceDetectionRequest.getMarketplaceId();
        this.statusId = createMarketplaceDetectionRequest.getStatusId();
        this.stateId = createMarketplaceDetectionRequest.getStateId();
        this.reasonCodesId = createMarketplaceDetectionRequest.getReasonCodesId();
    }
}
