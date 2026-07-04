package com.jobtracker.jobtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtracker.jobtracker.model.JobApplication;

public interface JobApplicationRepository  extends JpaRepository<JobApplication,Integer> {

    List<JobApplication> findByUserId(int userId);
} 
