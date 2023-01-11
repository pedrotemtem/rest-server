package com.appdetex.controller;

import com.appdetex.entity.Detection;
import com.appdetex.entity.Metric;
import com.appdetex.request.CreateMetricRequest;
import com.appdetex.response.DetectionResponse;
import com.appdetex.response.MetricResponse;
import com.appdetex.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/metrics/")
public class MetricController {

    @Autowired
    MetricService metricService;

    @GetMapping("")
    public List<MetricResponse> getAllMetrics () {

        List<Metric> metricsList = metricService.getAllMetrics();
        List<MetricResponse> metricsResponseList = new ArrayList<MetricResponse>();

        metricsList.stream().forEach(metric -> {
            metricsResponseList.add(new MetricResponse(metric));
        } );

        return metricsResponseList;
    }

    @PostMapping("create")
    public MetricResponse createMetric(@RequestBody CreateMetricRequest createMetricRequest) {

        Metric metric = metricService.createMetric(createMetricRequest);

        return new MetricResponse(metric);
    }
}
