package com.appdetex.repository;

import com.appdetex.entity.Detection;
import com.appdetex.entity.Role;
import com.appdetex.rulesengine.Rules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RulesRepository extends JpaRepository<Rules, Integer> {

}
