package com.appdetex.service;

import com.appdetex.entity.Metric;
import com.appdetex.repository.MetricRepository;
import com.appdetex.request.CreateMetricRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricService {

    @Autowired
    MetricRepository metricRepository;

    public List<Metric> getAllMetrics() {

        return metricRepository.findAll();
    }

    public Metric createMetric(CreateMetricRequest createMetricRequest) {

        Metric metric = new Metric(createMetricRequest);

        metric = metricRepository.save(metric);

        return metric;
    }
}
