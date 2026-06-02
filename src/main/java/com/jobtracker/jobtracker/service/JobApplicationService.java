package com.jobtracker.jobtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobtracker.jobtracker.model.JobApplication;
import com.jobtracker.jobtracker.repository.JobApplicationRepository;

@Service
public class JobApplicationService {
    @Autowired
    JobApplicationRepository  repo;
    public JobApplication saveJob(JobApplication jobApplication) {
        

    return repo.save(jobApplication);
    }
    public List<JobApplication> getbyUserId(int id) {
        return repo.findByUserId(id);

    }
    public void deletejobById(int id){
        repo.deleteById(id);

    }
    public void updateStatus(int id, String status){
       JobApplication job= repo.findById(id).get();
       job.setStatus(status);
       repo.save(job);
    }
    
}
