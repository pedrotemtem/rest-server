package com.appdetex.response;

import com.appdetex.entity.Audit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditResponse {

    private Integer id;
    private Integer analystId;
    private Integer detectionId;
    private String parameter;
    private String dateTime;
    private String oldValue;
    private String newValue;
    public AuditResponse (Audit audit) {
        this.id = audit.getId();
        this.analystId = audit.getAnalystId();
        this.detectionId = audit.getDetectionId();
        this.parameter = audit.getParameter();
        this.dateTime = audit.getDateTime();
        this.oldValue = audit.getOldValue();
        this.newValue = audit.getNewValue();
    }
}