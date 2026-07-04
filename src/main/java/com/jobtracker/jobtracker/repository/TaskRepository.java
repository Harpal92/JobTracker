package com.jobtracker.jobtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jobtracker.jobtracker.model.Task;


    public interface TaskRepository  extends JpaRepository<Task,Integer> {

    List<Task> findByUserId(int userId);
    @Query("SELECT t.status, COUNT(t) FROM Task t WHERE t.userId = :userId GROUP BY t.status")
List<Object[]> countByStatus(@Param("userId") int userId);
} 

