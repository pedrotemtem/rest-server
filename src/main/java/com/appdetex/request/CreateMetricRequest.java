package com.appdetex.request;

import lombok.Getter;
import lombok.Setter;

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
