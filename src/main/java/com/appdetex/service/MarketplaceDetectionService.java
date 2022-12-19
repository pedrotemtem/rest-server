package com.appdetex.service;


import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.repository.MarketplaceDetectionRepository;
import com.appdetex.request.CreateMarketplaceDetectionRequest;
import com.appdetex.request.UpdateMarketplaceDetectionRequest;
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
import java.util.List;

@Service
public class MarketplaceDetectionService {

    @Autowired
    MarketplaceDetectionRepository marketplaceDetectionRepository;

    public List<MarketplaceDetection> getAllMarketplaceDetections() {

        return marketplaceDetectionRepository.findAll();
    }

    public MarketplaceDetection getDetection(int id) {

        return marketplaceDetectionRepository.findById(id);
    }

    public List<MarketplaceDetection> getByAccountId(int accountId)  {

        return marketplaceDetectionRepository.findByAccountId(accountId);
    }

    public MarketplaceDetection createMarketplaceDetection(CreateMarketplaceDetectionRequest createMarketplaceDetectionRequest) {

        MarketplaceDetection marketplaceDetection = new MarketplaceDetection(createMarketplaceDetectionRequest);

        RuleJacuzziBrand ruleJacuzziBrand = new RuleJacuzziBrand();
        ruleJacuzziBrand.rulesChecker(marketplaceDetection);

        RuleJacuzziInflatable ruleJacuzziInflatable = new RuleJacuzziInflatable();
        ruleJacuzziInflatable.rulesChecker(marketplaceDetection);

        RuleSellers ruleSellers = new RuleSellers();
        ruleSellers.rulesChecker(marketplaceDetection);

        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);

        return marketplaceDetection;
    }

    public MarketplaceDetection updateMarketplaceDetection(UpdateMarketplaceDetectionRequest updateMarketplaceDetectionRequest) {

        MarketplaceDetection marketplaceDetection = marketplaceDetectionRepository.findById(updateMarketplaceDetectionRequest.getId()).get();
        String parameter;

        if (updateMarketplaceDetectionRequest.getState() != null && !updateMarketplaceDetectionRequest.getState().isEmpty()) {
            String oldValue = marketplaceDetection.getState();
            marketplaceDetection.setState(updateMarketplaceDetectionRequest.getState());
            String newValue = marketplaceDetection.getState();
            parameter = "state";
            postAudit(updateMarketplaceDetectionRequest, parameter, oldValue, newValue);
        }

        if (updateMarketplaceDetectionRequest.getStatus() != null && !updateMarketplaceDetectionRequest.getStatus().isEmpty()) {
            String oldValue = marketplaceDetection.getStatus();
            marketplaceDetection.setStatus(updateMarketplaceDetectionRequest.getStatus());
            String newValue = marketplaceDetection.getStatus();
            parameter = "status";
            postAudit(updateMarketplaceDetectionRequest, parameter, oldValue, newValue);
        }

        if (updateMarketplaceDetectionRequest.getReasonCode() != null && !updateMarketplaceDetectionRequest.getReasonCode().isEmpty()) {
            marketplaceDetection.setReasonCode(updateMarketplaceDetectionRequest.getReasonCode());
        }

        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);
        return marketplaceDetection;
    }

    private static void postAudit(UpdateMarketplaceDetectionRequest updateMarketplaceDetectionRequest,
                                  String parameter, String oldValue, String newValue) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        if (parameter.equals("state")) {
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost("http://localhost:8008/api/audit/create");
                String json = "{ \"analystsId\" : \"" + updateMarketplaceDetectionRequest.getAnalystId()
                        + "\",\"marketplaceDetectionsId\" : \"" + updateMarketplaceDetectionRequest.getId()
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
                String json = "{ \"analystsId\" : \"" + updateMarketplaceDetectionRequest.getAnalystId()
                        + "\",\"marketplaceDetectionsId\" : \"" + updateMarketplaceDetectionRequest.getId()
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

    public String deleteMarketplaceDetection (int id) {

        marketplaceDetectionRepository.deleteById(id);
        return "Detection has been deleted successfully";
    }
}
