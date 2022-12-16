package com.appdetex.service;


import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.repository.MarketplaceDetectionRepository;
import com.appdetex.request.CreateMarketplaceDetectionRequest;
import com.appdetex.request.UpdateMarketplaceDetectionRequest;
import com.appdetex.rulesengine.RuleAppleSeller;
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
import java.util.List;

@Service
public class MarketplaceDetectionService {

    @Autowired
    MarketplaceDetectionRepository marketplaceDetectionRepository;

    public List<MarketplaceDetection> getAllMarketplaceDetections() {

        return marketplaceDetectionRepository.findAll();
    }

    public List<MarketplaceDetection> getByAccountId(int account_id)  {

        return marketplaceDetectionRepository.findByAccountId(account_id);
    }

    public MarketplaceDetection createMarketplaceDetection(CreateMarketplaceDetectionRequest createMarketplaceDetectionRequest) {

        MarketplaceDetection marketplaceDetection = new MarketplaceDetection(createMarketplaceDetectionRequest);

        RuleJacuzziBrand ruleJacuzziBrand = new RuleJacuzziBrand();
        ruleJacuzziBrand.rulesChecker(marketplaceDetection);

        RuleJacuzziInflatable ruleJacuzziInflatable = new RuleJacuzziInflatable();
        ruleJacuzziInflatable.rulesChecker(marketplaceDetection);

        RuleAppleSeller ruleAppleSeller = new RuleAppleSeller();
        ruleAppleSeller.rulesChecker(marketplaceDetection);

        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);

        return marketplaceDetection;
    }

    public MarketplaceDetection updateMarketplaceDetection(UpdateMarketplaceDetectionRequest updateMarketplaceDetectionRequest) {

        MarketplaceDetection marketplaceDetection = marketplaceDetectionRepository.findById(updateMarketplaceDetectionRequest.getId()).get();
        String parameter;

        if (updateMarketplaceDetectionRequest.getState() != null && !updateMarketplaceDetectionRequest.getState().isEmpty()) {
            marketplaceDetection.setState(updateMarketplaceDetectionRequest.getState());
            parameter = "state";
            postAudit(updateMarketplaceDetectionRequest, parameter);
        }

        if (updateMarketplaceDetectionRequest.getStatus() != null && !updateMarketplaceDetectionRequest.getStatus().isEmpty()) {
            marketplaceDetection.setStatus(updateMarketplaceDetectionRequest.getStatus());
            parameter = "status";
            postAudit(updateMarketplaceDetectionRequest, parameter);
        }

        if (updateMarketplaceDetectionRequest.getReason_code() != null && !updateMarketplaceDetectionRequest.getReason_code().isEmpty()) {
            marketplaceDetection.setReason_code(updateMarketplaceDetectionRequest.getReason_code());
        }

        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);
        return marketplaceDetection;
    }

    private static void postAudit(UpdateMarketplaceDetectionRequest updateMarketplaceDetectionRequest, String parameter) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        int analystId = updateMarketplaceDetectionRequest.getAnalystId();

        if (parameter.equals("state")) {
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost("http://localhost:8008/api/audit/create");
                String json = "{ \"analysts_id\" : \""+ analystId +"\",\"marketplace_detections_id\" : \"" + updateMarketplaceDetectionRequest.getId() + "\",\"parameter\" : \"state\",\"date_time\" : \"" + dtf.format(LocalDateTime.now()) + "\"}";
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
                String json = "{ \"analysts_id\" : \"" + analystId + "\",\"marketplace_detections_id\" : \"" + updateMarketplaceDetectionRequest.getId() + "\",\"parameter\" : \"status\",\"date_time\" : \"" + dtf.format(LocalDateTime.now()) + "\"}";
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

    public String deleteMarketplaceDetection (int id) {
        marketplaceDetectionRepository.deleteById(id);
        return "Detection has been deleted successfully";
    }
}
