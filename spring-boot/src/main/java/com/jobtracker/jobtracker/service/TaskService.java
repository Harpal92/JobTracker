package com.jobtracker.jobtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jobtracker.jobtracker.model.Task;
import com.jobtracker.jobtracker.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    TaskRepository  repo;
    public Task saveTask(Task task) {
        

    return repo.save(task);
    }
     public List<Task> getbyUserId(int id) {
        return repo.findByUserId(id);

    }
    public void deletejobById(int id){
        repo.deleteById(id);

    }
    public void updateStatus(int id, String status){
       Task task= repo.findById(id).get();
       task.setStatus(status);
       repo.save(task);
    }
}
