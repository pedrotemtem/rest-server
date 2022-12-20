package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAuditRequest {

    private Integer analystsId;
    private Integer detectionId;
    private String parameter;
    private String dateTime;
    private String oldValue;
    private String newValue;
}