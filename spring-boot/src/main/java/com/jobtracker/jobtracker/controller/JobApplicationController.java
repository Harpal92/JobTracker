package com.jobtracker.jobtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.jobtracker.model.JobApplication;
import com.jobtracker.jobtracker.service.JobApplicationService;


@RestController
@RequestMapping("/jobs") 
public class JobApplicationController {
 @Autowired
    JobApplicationService service;
     @PostMapping("/add")
     public JobApplication add(@RequestBody JobApplication jobapplication){
         return service.saveJob(jobapplication);
     }
     @GetMapping("/get/{userId}")
     public List<JobApplication> get(@PathVariable int userId){
        return service.getbyUserId(userId);
     }
     @DeleteMapping("delete/{id}")
     public void delete(@PathVariable int id){
        service.deletejobById(id);
     }
      @PutMapping("update/{id}")
      public void update(@PathVariable int id, @RequestBody String  status){
        service.updateStatus(id,status);
      }
}

