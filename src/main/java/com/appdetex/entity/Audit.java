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
    private Integer analystId;

    @Column(name = "marketplace_detections_id")
    private Integer detectionId;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

    public Audit(CreateAuditRequest createAuditRequest){
        this.analystId = createAuditRequest.getAnalystsId();
        this.detectionId = createAuditRequest.getDetectionId();
        this.parameter = createAuditRequest.getParameter();
        this.dateTime = createAuditRequest.getDateTime();
        this.oldValue = createAuditRequest.getOldValue();
        this.newValue = createAuditRequest.getNewValue();
    }
}