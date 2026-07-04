package com.jobtracker.jobtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.jobtracker.jobtracker.model.DailyLog;

import com.jobtracker.jobtracker.repository.DailyLogRepository;


@Service
public class DailyLogService {
    @Autowired
    DailyLogRepository  repo;
     public DailyLog savelog(@NonNull  DailyLog dailylog) {
        

    return repo.save(dailylog);
    }

public List<DailyLog> getbyUserId(int id) {
        return repo.findByUserId(id);

    }
    public void deletejobById(int id){
        repo.deleteById(id);

    }
    public DailyLog getlogbyid(int id){
      return  repo.findById(id).get();
    }
    
    
}
