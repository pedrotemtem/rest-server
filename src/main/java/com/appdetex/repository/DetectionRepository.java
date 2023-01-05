package com.appdetex.repository;

import com.appdetex.entity.Detection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface DetectionRepository extends JpaRepository<Detection, Integer> {

    List<Detection> findByAccountId(int accountId);
    Detection findById(int id);
    @Query(value = "SELECT date1, marketplace, count(id)\n" +
            "FROM (SELECT STR_TO_DATE(SUBSTRING(capture_date,1,10),\"%Y/%m/%d\") AS date1, marketplace, id FROM detections) AS D\n" +
            "WHERE date1 >= :date\n" +
            "GROUP BY 1,2\n" +
            "ORDER BY date1 ASC\n" +
            "LIMIT :limit ;",nativeQuery = true)
    ArrayList<String> getNumberDetectionsByDay(@Param("date") String date, @Param("limit") int limit);
}
