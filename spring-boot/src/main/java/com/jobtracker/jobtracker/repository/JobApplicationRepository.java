package com.jobtracker.jobtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jobtracker.jobtracker.model.JobApplication;

public interface JobApplicationRepository  extends JpaRepository<JobApplication,Integer> {

    List<JobApplication> findByUserId(int userId);
    @Query("SELECT j.status, COUNT(j) FROM JobApplication j WHERE j.userId = :userId GROUP BY j.status")
List<Object[]> countByStatus(@Param("userId") int userId);
} 
