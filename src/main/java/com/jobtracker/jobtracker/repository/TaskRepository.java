package com.jobtracker.jobtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jobtracker.jobtracker.model.Task;


    public interface TaskRepository  extends JpaRepository<Task,Integer> {

    List<Task> findByUserId(int userId);
} 

