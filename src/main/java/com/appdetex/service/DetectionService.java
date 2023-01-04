package com.appdetex.service;


import com.appdetex.entity.Detection;
import com.appdetex.repository.DetectionRepository;
import com.appdetex.request.CreateDetectionRequest;
import com.appdetex.request.UpdateDetectionRequest;
import com.appdetex.rulesengine.RuleSellers;
import com.appdetex.rulesengine.RuleJacuzziInflatable;
import com.appdetex.rulesengine.RuleJacuzziBrand;
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

    public ArrayList<String> getDetectionsByDay() {

        return detectionRepository.getNumberDetectionsByDay();
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

    public Detection createDetection(CreateDetectionRequest createDetectionRequest) {

        Detection detection = new Detection(createDetectionRequest);

        RuleJacuzziBrand ruleJacuzziBrand = new RuleJacuzziBrand();
        ruleJacuzziBrand.rulesChecker(detection);

        RuleJacuzziInflatable ruleJacuzziInflatable = new RuleJacuzziInflatable();
        ruleJacuzziInflatable.rulesChecker(detection);

        RuleSellers ruleSellers = new RuleSellers();
        ruleSellers.rulesChecker(detection);

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

        if (parameter.equals("state")) {
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost("http://localhost:8008/api/audit/create");
                String json = "{ \"userId\" : \"" + updateDetectionRequest.getUserId()
                        + "\",\"detectionId\" : \"" + updateDetectionRequest.getId()
                        + "\",\"parameter\" : \"" + parameter
                        + "\",\"dateTime\" : \"" + dtf.format(LocalDateTime.now())
                        + "\",\"oldValue\" : \"" + oldValue
                        + "\",\"newValue\" : \"" + newValue + "\"}";
                StringEntity entity = new StringEntity(json, "UTF-8");
                httpPost.setEntity(entity);
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json;charset=UTF-8");
                CloseableHttpResponse response = client.execute(httpPost);
                parameter = null;
            } catch (ClientProtocolException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (parameter.equals("status")) {
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost("http://localhost:8008/api/audit/create");
                String json = "{ \"userId\" : \"" + updateDetectionRequest.getUserId()
                        + "\",\"detectionId\" : \"" + updateDetectionRequest.getId()
                        + "\",\"parameter\" : \"" + parameter
                        + "\",\"dateTime\" : \"" + dtf.format(LocalDateTime.now())
                        + "\",\"oldValue\" : \"" + oldValue
                        + "\",\"newValue\" : \"" + newValue + "\"}";
                StringEntity entity = new StringEntity(json, "UTF-8");
                httpPost.setEntity(entity);
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json;charset=UTF-8");
                CloseableHttpResponse response = client.execute(httpPost);
                parameter = null;
            } catch (ClientProtocolException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String deleteDetection(int id) {

        detectionRepository.deleteById(id);
        return "Detection has been deleted successfully";
    }
}
