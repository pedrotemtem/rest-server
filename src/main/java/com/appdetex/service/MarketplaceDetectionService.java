package com.appdetex.service;

import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.repository.MarketplaceDetectionRepository;
import com.appdetex.request.CreateMarketplaceDetectionRequest;
import com.appdetex.request.UpdateMarketplaceDetectionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (updateMarketplaceDetectionRequest.getState() != null && !updateMarketplaceDetectionRequest.getState().isEmpty()) {
            marketplaceDetection.setState(updateMarketplaceDetectionRequest.getState());
        }
        if (updateMarketplaceDetectionRequest.getStatus() != null && !updateMarketplaceDetectionRequest.getStatus().isEmpty()) {
            marketplaceDetection.setStatus(updateMarketplaceDetectionRequest.getStatus());
        }
        if (updateMarketplaceDetectionRequest.getReason_code() != null && !updateMarketplaceDetectionRequest.getReason_code().isEmpty()) {
            marketplaceDetection.setReason_code(updateMarketplaceDetectionRequest.getReason_code());
        }

        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);
        return marketplaceDetection;
    }

    public String deleteMarketplaceDetection (int id){
        marketplaceDetectionRepository.deleteById(id);
        return "Detection has been deleted successfully";
    }
}
