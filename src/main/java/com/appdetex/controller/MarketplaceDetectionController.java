package com.appdetex.controller;

import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.response.MarketplaceDetectionResponse;
import com.appdetex.service.MarketplaceDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/detection")
public class MarketplaceDetectionController {

    @Autowired
    MarketplaceDetectionService marketplaceDetectionService;

    @GetMapping("/getAll")
    public List<MarketplaceDetectionResponse> getAllMarketplaceDetection(){
        List<MarketplaceDetection> marketplaceDetectionList = marketplaceDetectionService.getAllMarketplaceDetection();
        List<MarketplaceDetectionResponse> marketplaceDetectionResponseList = new ArrayList<MarketplaceDetectionResponse>();

        marketplaceDetectionList.stream().forEach(marketplaceDetection -> {
            marketplaceDetectionResponseList.add(new MarketplaceDetectionResponse(marketplaceDetection));
        });

        return marketplaceDetectionResponseList;
    }
}
