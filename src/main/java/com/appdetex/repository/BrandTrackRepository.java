package com.appdetex.repository;

import com.appdetex.entity.BrandTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandTrackRepository extends JpaRepository<BrandTrack, Integer> {

    List<BrandTrack> findByAccountId(int accountId);
}
