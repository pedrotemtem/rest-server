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
    @Column(name="Harvest Process")
    private String harvestProcess;

    @Id
    @Column(name="Marketplace")
    private String marketplace;

    @Column(name="NumItems")
    private int numItems;

    @Column(name="Max")
    private int max;

    @Column(name="Min")
    private int min;

    @Column(name="Avg")
    private int avg;

    @Column(name="Sum")
    private int sum;

    public Metric(CreateMetricRequest createMetricRequest) {

    }




}
