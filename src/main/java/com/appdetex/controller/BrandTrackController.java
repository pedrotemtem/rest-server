package com.appdetex.controller;

import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.request.CreateBrandTrackRequest;
import com.appdetex.response.BrandTrackResponse;
import com.appdetex.response.MarketplaceDetectionResponse;
import com.appdetex.service.BrandTrackService;
import com.appdetex.entity.BrandTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/brandtracks/")
public class BrandTrackController {

    @Autowired
    BrandTrackService brandTrackService;

    @GetMapping("getAll")
    public List<BrandTrackResponse> getAllBrandTracks() {

        List<BrandTrack> brandTrackList = brandTrackService.getAllBrandTracks();
        List<BrandTrackResponse> brandTrackResponseList = new ArrayList<BrandTrackResponse>();

        brandTrackList.stream().forEach(brandTrack -> {
            brandTrackResponseList.add(new BrandTrackResponse(brandTrack));
        });

        return brandTrackResponseList;
    }

    @GetMapping("getByAccount/{accountId}")
    public List<BrandTrackResponse> getByAccountId(@PathVariable int accountId){

        List<BrandTrack> brandTrackList = brandTrackService.getByAccountId(accountId);
        List<BrandTrackResponse> brandTrackResponseList = new ArrayList<BrandTrackResponse>();

        brandTrackList.stream().forEach(brandTrack -> {
            brandTrackResponseList.add(new BrandTrackResponse(brandTrack));
        });

        return brandTrackResponseList;
    }

    @PostMapping("create")
    public BrandTrackResponse createBrandTrack(@RequestBody CreateBrandTrackRequest createBrandTrackRequest){

        BrandTrack brandTrack = brandTrackService.createBrandTrack(createBrandTrackRequest);
        return new BrandTrackResponse(brandTrack);
    }

    @DeleteMapping("delete/{id}")
    public String deleteBrandTrack(@PathVariable int id){

        return brandTrackService.deleteBrandTrack(id);
    }
}
