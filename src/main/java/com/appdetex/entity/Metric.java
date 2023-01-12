package com.appdetex.entity;

import com.appdetex.request.CreateMetricRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(MetricPkId.class)
@Table(name = "metrics")
public class Metric {

    @Id
    @Column(name="harvest_process")
    private String harvestProcess;

    @Id
    @Column(name="marketplace")
    private String marketplace;

    @Column(name="num_items")
    private int numItems;

    @Column(name="max")
    private int max;

    @Column(name="min")
    private int min;

    @Column(name="avg")
    private int avg;

    @Column(name="sum")
    private int sum;

    public Metric(CreateMetricRequest createMetricRequest) {
        this.harvestProcess = createMetricRequest.getHarvestProcess();
        this.marketplace = createMetricRequest.getMarketplace();
        this.numItems = createMetricRequest.getNumItems();
        this.max = createMetricRequest.getMax();
        this.min = createMetricRequest.getMin();
        this.avg = createMetricRequest.getAvg();
        this.sum = createMetricRequest.getSum();
    }
}