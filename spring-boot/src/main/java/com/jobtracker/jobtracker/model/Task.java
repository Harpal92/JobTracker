package com.jobtracker.jobtracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_table")
public class Task {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  private int userId;
  private String title;
    private String  description;
    private String  status;
    private String  date;

    public Task(String title, String description,String status,String date,int userId){
        this.title=title;
        this.description=description;
        this.status=status;
        this.date=date;
        this.userId=userId;
    }
    public Task(){

    }
    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    
    public String getStatus() {
        return status;
    }
    public String getTitle() {
        return title;
    }
    public int getUserId() {
        return userId;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
