package com.appdetex.service;

import com.appdetex.repository.BrandTrackRepository;
import com.appdetex.request.CreateBrandTrackRequest;
import com.appdetex.entity.BrandTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandTrackService {

    @Autowired
    BrandTrackRepository brandTrackRepository;

    public List<BrandTrack> getAllBrandTracks() {

        return brandTrackRepository.findAll();
    }

    public List<BrandTrack> getByAccountId(int accountId)  {

        return brandTrackRepository.findByAccountId(accountId);
    }

    public BrandTrack createBrandTrack(CreateBrandTrackRequest createBrandTrackRequest) {

        BrandTrack brandTrack = new BrandTrack(createBrandTrackRequest);
        return brandTrackRepository.save(brandTrack);
    }

    public String deleteBrandTrack(int id){

        brandTrackRepository.deleteById(id);
        return "Brand track has been deleted successfully";
    }
}
