package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
public class CreateMetricRequest {

    private String harvestProcess;
    private String marketplace;
    private int numItems;
    private int max;
    private int min;
    private int avg;
    private int sum;
}
