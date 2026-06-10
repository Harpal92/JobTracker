package com.jobtracker.jobtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.jobtracker.jobtracker.model.Task;
import com.jobtracker.jobtracker.model.User;
import com.jobtracker.jobtracker.service.TaskService;
import com.jobtracker.jobtracker.service.UserService;

@RestController
@RequestMapping("/tasks") 
public class TaskController {
    @Autowired
UserService userService;
   @Autowired
    TaskService service;
     @PostMapping("/add")
     public Task add(@RequestBody Task task){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = userService.findbyemail(email);
        task.setUserId(user.getId());
         return service.saveTask(task);
     }
     @GetMapping("/get/{userId}")
     public List<Task> get(@PathVariable int userId){
      String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = userService.findbyemail(email);
    if(user.getId() != userId) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        return service.getbyUserId(userId);
     }
     @DeleteMapping("delete/{id}")
     public void delete(@PathVariable int id){
       String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = userService.findbyemail(email);
    Task task=service.gettaskById(id);
    if(task.getUserId()!=user.getId())  throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        service.deletetaskById(id);

        
     }
      @PutMapping("update/{id}")
      public void update(@PathVariable int id, @RequestBody String  status){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = userService.findbyemail(email);
    Task task=service.gettaskById(id);
    if(task.getUserId()!=user.getId())  throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
       
        service.updateStatus(id,status);
      }
}

  

