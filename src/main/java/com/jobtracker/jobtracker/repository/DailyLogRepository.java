package com.jobtracker.jobtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtracker.jobtracker.model.DailyLog;

public interface DailyLogRepository extends JpaRepository<DailyLog,Integer> {

    List<DailyLog> findByUserId(int userId);
} 