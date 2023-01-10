package com.appdetex.service;


import com.appdetex.entity.Detection;
import com.appdetex.repository.DetectionRepository;
import com.appdetex.request.CreateAuditRequest;
import com.appdetex.request.CreateDetectionRequest;
import com.appdetex.request.UpdateDetectionRequest;
import com.appdetex.rulesengine.SellerRule;
import com.appdetex.rulesengine.InflatableJacuzziRule;
import com.appdetex.rulesengine.JacuzziBrandRule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetectionService {

    @Autowired
    DetectionRepository detectionRepository;

    @Autowired
    RulesRepository rulesRepository;

    public ArrayList<String> getDetectionsByDay(String initialDate, String endingDate) {

        return detectionRepository.getNumberDetectionsByDay(initialDate, endingDate);
    }

    public List<Detection> getAllDetections() {

        return detectionRepository.findAll();
    }

    public Detection getDetection(int id) {

        return detectionRepository.findById(id);
    }

    public List<Detection> getByAccountId(int accountId)  {

        return detectionRepository.findByAccountId(accountId);
    }

    public void addRulesToRep(){
        Rules brandRules = new BrandRules();
        Rules inflatableJacuzziRule = new InflatableJacuzziRule();
        Rules sellerRules =new SellerRules();

        rulesRepository.save(brandRules);
        rulesRepository.save(inflatableJacuzziRule);
        rulesRepository.save(sellerRules);
    }

    public Detection createDetection(CreateDetectionRequest createDetectionRequest) {

        Detection detection = new Detection(createDetectionRequest);

        addRulesToRep();

        List<Rules> rule = rulesRepository.findAll();
        for (Rules rules1 : rule) {
            rules1.checkRules(detection);
        }

        detection = detectionRepository.save(detection);

        return detection;
    }

    public Detection updateDetection(UpdateDetectionRequest updateDetectionRequest) {

        Detection detection = detectionRepository.findById(updateDetectionRequest.getId()).get();
        String parameter;

        if (updateDetectionRequest.getState() != null && !updateDetectionRequest.getState().isEmpty()) {
            String oldValue = detection.getState();
            detection.setState(updateDetectionRequest.getState());
            String newValue = detection.getState();
            parameter = "state";
            postAudit(updateDetectionRequest, parameter, oldValue, newValue);
        }

        if (updateDetectionRequest.getStatus() != null && !updateDetectionRequest.getStatus().isEmpty()) {
            String oldValue = detection.getStatus();
            detection.setStatus(updateDetectionRequest.getStatus());
            String newValue = detection.getStatus();
            parameter = "status";
            postAudit(updateDetectionRequest, parameter, oldValue, newValue);
        }

        if (updateDetectionRequest.getReasonCode() != null && !updateDetectionRequest.getReasonCode().isEmpty()) {
            detection.setReasonCode(updateDetectionRequest.getReasonCode());
        }

        detection = detectionRepository.save(detection);
        return detection;
    }

    private static void postAudit(UpdateDetectionRequest updateDetectionRequest,
                                  String parameter, String oldValue, String newValue) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        CreateAuditRequest createAuditRequest = new CreateAuditRequest();

        if (updateDetectionRequest.getState() != null && !updateDetectionRequest.getState().isEmpty()) {

            createAuditRequest.setUserId(updateDetectionRequest.getUserId());
            createAuditRequest.setDetectionId(updateDetectionRequest.getId());
            createAuditRequest.setParameter("state");
            createAuditRequest.setDateTime(dtf.format((LocalDateTime.now())));
            createAuditRequest.setOldValue(detection.getState());
            detection.setState(updateDetectionRequest.getState());
            createAuditRequest.setNewValue(detection.getState());
            auditService.createAudit(createAuditRequest);
        }

        if (updateDetectionRequest.getStatus() != null && !updateDetectionRequest.getStatus().isEmpty()) {

            createAuditRequest.setUserId(updateDetectionRequest.getUserId());
            createAuditRequest.setDetectionId(updateDetectionRequest.getId());
            createAuditRequest.setParameter("status");
            createAuditRequest.setDateTime(dtf.format((LocalDateTime.now())));
            createAuditRequest.setOldValue(detection.getStatus());
            detection.setStatus(updateDetectionRequest.getStatus());
            createAuditRequest.setNewValue(detection.getStatus());
            auditService.createAudit(createAuditRequest);
        }

        if (updateDetectionRequest.getReasonCode() != null && !updateDetectionRequest.getReasonCode().isEmpty()) {
            detection.setReasonCode(updateDetectionRequest.getReasonCode());
        }

        return detectionRepository.save(detection);
    }

    public String deleteDetection(int id) {

        detectionRepository.deleteById(id);
        return "Detection has been deleted successfully";
    }
}
