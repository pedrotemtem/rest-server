package com.appdetex.repository;

import com.appdetex.entity.MarketplaceDetection;
import com.appdetex.service.MarketplaceDetectionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MarketplaceDetectionRepository extends JpaRepository<MarketplaceDetection, Integer> {

    List<MarketplaceDetection> findByAccountId(int accountId);

    MarketplaceDetection findById(int id);
}
