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
    private Integer analysts_id;

    @Column(name = "marketplace_detections_id")
    private Integer marketplace_detections_id;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "date_time")
    private String date_time;

    public Audit(CreateAuditRequest createAuditRequest){
        this.analysts_id = createAuditRequest.getAnalysts_id();
        this.marketplace_detections_id = createAuditRequest.getMarketplace_detections_id();
        this.parameter = createAuditRequest.getParameter();
        this.date_time = createAuditRequest.getDate_time();
    }

}