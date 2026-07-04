package com.jobtracker.jobtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jobtracker.jobtracker.model.DailyLog;

public interface DailyLogRepository extends JpaRepository<DailyLog,Integer> {

    List<DailyLog> findByUserId(int userId);
    @Query("SELECT SUM(d.hourspent) FROM DailyLog d WHERE d.userId = :userId")
Double sumHoursSpent(@Param("userId") int userId);

@Query("SELECT COUNT(DISTINCT d.topic) FROM DailyLog d WHERE d.userId = :userId")
Long countDistinctTopics(@Param("userId") int userId);
} 