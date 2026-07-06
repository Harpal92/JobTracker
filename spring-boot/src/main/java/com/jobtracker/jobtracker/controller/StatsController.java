package com.jobtracker.jobtracker.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jobtracker.jobtracker.model.User;
import com.jobtracker.jobtracker.service.StatsService;
import com.jobtracker.jobtracker.service.UserService;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;
    @Autowired
    private UserService userServices;

    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getStats(@PathVariable int userId) {
          String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
                 User user = userServices.findbyemail(email);
                  if (user.getId() != userId) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Access denied");
        }


        return ResponseEntity.ok(statsService.getStats(userId));
    }
}