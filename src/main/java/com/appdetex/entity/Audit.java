package com.appdetex.entity;

import com.appdetex.request.CreateAuditRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "analysts_id")
    private Integer analystsId;

    @Column(name = "marketplace_detections_id")
    private Integer marketplaceDetectionsId;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "date_time")
    private String dateTime;

    public Audit(CreateAuditRequest createAuditRequest){
        this.analystsId = createAuditRequest.getAnalystsId();
        this.marketplaceDetectionsId = createAuditRequest.getMarketplaceDetectionsId();
        this.parameter = createAuditRequest.getParameter();
        this.dateTime = createAuditRequest.getDateTime();
    }
}