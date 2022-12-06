package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class UpdateAuditRequest {

    @Positive(message="Audit ID is required")
    private Integer id;

    private Integer analysts_id;

    private Integer marketplace_detections_id;

    private String parameter;

    private String date_time;

}
