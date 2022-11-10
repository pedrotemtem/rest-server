package com.appdetex.service;

import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.repository.MarketplaceDetectionRepository;
import com.appdetex.request.CreateMarketplaceDetectionRequest;
import com.appdetex.request.UpdateMarketplaceDetectionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@Service

public class MarketplaceDetectionService {

    @Autowired
    MarketplaceDetectionRepository marketplaceDetectionRepository;

    public List<MarketplaceDetection> getAllMarketplaceDetection(){
        return marketplaceDetectionRepository.findAll();
    }

    public MarketplaceDetection createMarketplaceDetection (CreateMarketplaceDetectionRequest createMarketplaceDetectionRequest){
        MarketplaceDetection marketplaceDetection = new MarketplaceDetection(createMarketplaceDetectionRequest);
        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);

        return marketplaceDetection;
    }

    public MarketplaceDetection updateMarketplaceDetection (UpdateMarketplaceDetectionRequest updateMarketplaceDetectionRequest){
        MarketplaceDetection marketplaceDetection = marketplaceDetectionRepository.findById(updateMarketplaceDetectionRequest.getId()).get();

        if (updateMarketplaceDetectionRequest.getTitle() != null &&
                !updateMarketplaceDetectionRequest.getTitle().isEmpty()){
            marketplaceDetection.setStateId(updateMarketplaceDetectionRequest.getStateId());
        }

        marketplaceDetection = marketplaceDetectionRepository.save(marketplaceDetection);
        return marketplaceDetection;
    }

    public String deleteMarketplaceDetection (long id){
        marketplaceDetectionRepository.deleteById(id);

        return "Marketplace Detection with {id} deleted successfully";
    }


}
