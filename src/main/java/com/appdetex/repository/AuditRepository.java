package com.appdetex.repository;

import com.appdetex.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {

    List<Audit> findByMarketplaceDetectionsId(int marketplaceDetectionsId);
}

