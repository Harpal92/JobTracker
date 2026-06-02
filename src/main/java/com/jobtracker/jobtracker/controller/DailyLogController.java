package com.jobtracker.jobtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.jobtracker.model.DailyLog;

import com.jobtracker.jobtracker.service.DailyLogService;


@RestController
@RequestMapping("/logs") 
public class DailyLogController {
     @Autowired
    DailyLogService service;
     @PostMapping("/add")
     public DailyLog add(@RequestBody DailyLog dailylog){
         return service.savelog(dailylog);
     }
     @GetMapping("/get/{userId}")
     public List<DailyLog> get(@PathVariable int userId){
        return service.getbyUserId(userId);
     }
     @DeleteMapping("delete/{id}")
     public void delete(@PathVariable int id){
        service.deletejobById(id);
     }
}
