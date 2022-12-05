package com.appdetex.controller;

import com.appdetex.entity.Audit;
import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.request.CreateMarketplaceDetectionRequest;
import com.appdetex.request.UpdateMarketplaceDetectionRequest;
import com.appdetex.response.AuditResponse;
import com.appdetex.response.MarketplaceDetectionResponse;
import com.appdetex.service.AuditService;
import com.appdetex.service.MarketplaceDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/marketplacedetections/")
public class MarketplaceDetectionController {

    @Autowired
    MarketplaceDetectionService marketplaceDetectionService;
    AuditService auditService;

    @GetMapping("getAll")
    public List<MarketplaceDetectionResponse> getAllMarketplaceDetections() {
        List<MarketplaceDetection> marketplaceDetectionList = marketplaceDetectionService.getAllMarketplaceDetections();
        List<MarketplaceDetectionResponse> marketplaceDetectionResponseList = new ArrayList<MarketplaceDetectionResponse>();

        marketplaceDetectionList.stream().forEach(marketplaceDetection -> {
            marketplaceDetectionResponseList.add(new MarketplaceDetectionResponse(marketplaceDetection));
        });

        return marketplaceDetectionResponseList;
    }

    @GetMapping("getByAccount/{account_id}")
    public List<MarketplaceDetectionResponse> getByAccountId(@PathVariable int account_id){
        List<MarketplaceDetection> marketplaceDetectionList = marketplaceDetectionService.getByAccountId(account_id);
        List<MarketplaceDetectionResponse> marketplaceDetectionResponseList = new ArrayList<MarketplaceDetectionResponse>();

        marketplaceDetectionList.stream().forEach(marketplaceDetection -> {
            marketplaceDetectionResponseList.add(new MarketplaceDetectionResponse(marketplaceDetection));
        });

        return marketplaceDetectionResponseList;
    }

    @PostMapping("create")
    public MarketplaceDetectionResponse createMarketplaceDetection(@RequestBody CreateMarketplaceDetectionRequest createMarketplaceDetectionRequest) {
        MarketplaceDetection marketplaceDetection = marketplaceDetectionService.createMarketplaceDetection(createMarketplaceDetectionRequest);

        return new MarketplaceDetectionResponse(marketplaceDetection);
    }

    @PutMapping("update")
    public MarketplaceDetectionResponse updateMarketplaceDetection(@RequestBody UpdateMarketplaceDetectionRequest updateMarketplaceDetectionRequest){
        MarketplaceDetection marketplaceDetection = marketplaceDetectionService.updateMarketplaceDetection(updateMarketplaceDetectionRequest);

        return new MarketplaceDetectionResponse(marketplaceDetection);
    }

    @DeleteMapping("delete")
    public String deleteMarketplaceDetection(@RequestParam int id){
        return marketplaceDetectionService.deleteMarketplaceDetection(id);
    }
}
