package com.appdetex.response;

import com.appdetex.entity.Audit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditResponse {
    private Integer id;
    private Integer analysts_id;
    private Integer marketplaceDetectionsId;
    private String parameter;
    private String date_time;
    public AuditResponse (Audit audit) {
        this.id = audit.getId();
        this.analysts_id = audit.getAnalysts_id();
        this.marketplaceDetectionsId = audit.getMarketplaceDetectionsId();
        this.parameter = audit.getParameter();
        this.date_time = audit.getDate_time();
    }
}