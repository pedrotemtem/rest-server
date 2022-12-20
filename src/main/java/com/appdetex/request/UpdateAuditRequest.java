package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class UpdateAuditRequest {

    @Positive(message="Audit ID is required")
    private Integer id;
    private Integer analystsId;
    private Integer marketplaceDetectionsId;
    private String parameter;
    private String dateTime;
    private String oldValue;
    private String newValue;
}
