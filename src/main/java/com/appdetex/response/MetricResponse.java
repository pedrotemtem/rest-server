package com.appdetex.response;

import com.appdetex.entity.Metric;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetricResponse {

    private String harvestProcess;
    private String marketplace;
    private int numItems;
    private int max;
    private int min;
    private int avg;
    private int sum;

    public MetricResponse(Metric metric) {
        this.harvestProcess = metric.getHarvestProcess();
        this.marketplace = metric.getMarketplace();
        this.max = metric.getMax();
        this.min = metric.getMin();
        this.avg = metric.getAvg();
        this.sum = metric.getSum();
    }
}
