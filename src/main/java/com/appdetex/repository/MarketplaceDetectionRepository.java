package com.appdetex.repository;

import com.appdetex.entity.MarketplaceDetection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketplaceDetectionRepository extends JpaRepository<MarketplaceDetection, Long> {
}
