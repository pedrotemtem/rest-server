package com.appdetex.service;

import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.repository.MarketplaceDetectionRepository;
import com.appdetex.request.CreateMarketplaceDetectionRequest;
import com.appdetex.request.UpdateMarketplaceDetectionRequest;
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

    public MarketplaceDetection createMarketplaceDetection(CreateMarketplaceDetectionRequest createMarketplaceDetectionRequest) {

        MarketplaceDetection marketplaceDetection = new MarketplaceDetection(createMarketplaceDetectionRequest);
        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);

        return marketplaceDetection;
    }

    public MarketplaceDetection updateMarketplaceDetection(UpdateMarketplaceDetectionRequest updateMarketplaceDetectionRequest) {

        MarketplaceDetection marketplaceDetection = marketplaceDetectionRepository.findById(updateMarketplaceDetectionRequest.getId()).get();
        String parameter = null;

        if (updateMarketplaceDetectionRequest.getState() != null && !updateMarketplaceDetectionRequest.getState().isEmpty()) {
            marketplaceDetection.setState(updateMarketplaceDetectionRequest.getState());
            parameter = "state";
        }
        if (updateMarketplaceDetectionRequest.getStatus() != null && !updateMarketplaceDetectionRequest.getStatus().isEmpty()) {
            marketplaceDetection.setStatus(updateMarketplaceDetectionRequest.getStatus());
            parameter = "status";
        }
        if (updateMarketplaceDetectionRequest.getReason_code() != null && !updateMarketplaceDetectionRequest.getReason_code().isEmpty()) {
            marketplaceDetection.setReason_code(updateMarketplaceDetectionRequest.getReason_code());
        }

        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);
        return marketplaceDetection;
    }

    public String deleteMarketplaceDetection (int id) {
        marketplaceDetectionRepository.deleteById(id);
        return "Detection has been deleted successfully";
    }
}
