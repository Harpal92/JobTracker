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


import com.jobtracker.jobtracker.model.Task;

import com.jobtracker.jobtracker.service.TaskService;

@RestController
@RequestMapping("/tasks") 
public class TaskController {
   @Autowired
    TaskService service;
     @PostMapping("/add")
     public Task add(@RequestBody Task task){
         return service.saveTask(task);
     }
     @GetMapping("/get/{userId}")
     public List<Task> get(@PathVariable int userId){
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

  

