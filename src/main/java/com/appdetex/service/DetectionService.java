package com.appdetex.service;


import com.appdetex.entity.Detection;
import com.appdetex.repository.DetectionRepository;
import com.appdetex.request.CreateAuditRequest;
import com.appdetex.request.CreateDetectionRequest;
import com.appdetex.request.UpdateDetectionRequest;
import com.appdetex.rulesengine.Rules;
import com.appdetex.rulesengine.SellerRules;
import com.appdetex.rulesengine.InflatableJacuzziRule;
import com.appdetex.rulesengine.BrandRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetectionService {

    @Autowired
    DetectionRepository detectionRepository;

    @Autowired
    AuditService auditService;

    ArrayList<Rules> rulesArrayList= new ArrayList<>();

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

        rulesArrayList.add(brandRules);
        rulesArrayList.add(inflatableJacuzziRule);
        rulesArrayList.add(sellerRules);
    }

    public Detection createDetection(CreateDetectionRequest createDetectionRequest) {

        Detection detection = new Detection(createDetectionRequest);

        addRulesToRep();

        for (Rules rules1 : rulesArrayList) {
            rules1.checkRules(detection);
        }

        detection = detectionRepository.save(detection);

        return detection;
    }

    public Detection updateDetection(UpdateDetectionRequest updateDetectionRequest) {

        Detection detection = detectionRepository.findById(updateDetectionRequest.getId()).get();
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
