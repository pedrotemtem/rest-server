package com.appdetex.repository;

import com.appdetex.entity.Detection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetectionRepository extends JpaRepository<Detection, Integer> {

    List<Detection> findByAccountId(int accountId);
    Detection findById(int id);
}
