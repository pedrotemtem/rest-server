package com.appdetex.response;

import com.appdetex.entity.Audit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditResponse {
    private Integer id;
    private Integer analysts_id;
    private Integer marketplace_detections_id;
    private String parameter;
    private String date_time;
    public AuditResponse (Audit audit) {
        this.id = audit.getId();
        this.analysts_id = audit.getAnalysts_id();
        this.marketplace_detections_id = audit.getMarketplace_detections_id();
        this.parameter = audit.getParameter();
        this.date_time = audit.getDate_time();
    }
}