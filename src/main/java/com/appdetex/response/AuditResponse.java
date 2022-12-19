package com.appdetex.response;

import com.appdetex.entity.Audit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditResponse {
    private Integer id;
    private Integer analystsId;
    private Integer marketplaceDetectionsId;
    private String parameter;
    private String dateTime;
    public AuditResponse (Audit audit) {
        this.id = audit.getId();
        this.analystsId = audit.getAnalystsId();
        this.marketplaceDetectionsId = audit.getMarketplaceDetectionsId();
        this.parameter = audit.getParameter();
        this.dateTime = audit.getDateTime();
    }
}