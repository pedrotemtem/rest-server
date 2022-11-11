package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAuditRequest {

    private Integer analysts_id;

    private Integer marketplace_detections_id;

    private String parameter;

    private String date_time;

}