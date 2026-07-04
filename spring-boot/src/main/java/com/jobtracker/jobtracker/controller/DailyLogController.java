package com.jobtracker.jobtracker.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jobtracker.jobtracker.model.User;
import com.jobtracker.jobtracker.model.DailyLog;

import com.jobtracker.jobtracker.service.DailyLogService;
import com.jobtracker.jobtracker.service.UserService;


@RestController
@RequestMapping("/logs") 
public class DailyLogController {
   @Autowired
UserService userService;
     @Autowired
    DailyLogService service;
     @PostMapping("/add")
     public DailyLog add(@RequestBody DailyLog dailylog){
       String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = userService.findbyemail(email);
    dailylog.setUserId(user.getId());
         return service.savelog(dailylog);
     }
     @GetMapping("/get/{userId}")
     public List<DailyLog> get(@PathVariable int userId){
      String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = userService.findbyemail(email);
    if(user.getId() != userId) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        return service.getbyUserId(userId);
        
     }
     @DeleteMapping("delete/{id}")
     public void delete(@PathVariable int id){
      String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user = userService.findbyemail(email);
     DailyLog log=service.getlogbyid(id);
    if(log.getUserId()!=user.getId())  throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        service.deletejobById(id);
     }
}
