package com.appdetex.repository;

import com.appdetex.entity.Analyst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalystRepository extends JpaRepository<Analyst, Integer> {

}
