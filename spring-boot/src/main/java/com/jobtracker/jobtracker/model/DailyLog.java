package com.jobtracker.jobtracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_log")
public class DailyLog {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
private int userId;
 @Column(name = "log_date")
 private String  logdate;
    private String  topic;
     @Column(name = "hours_spent")
   private double  hourspent;
   private String notes;
    public DailyLog(int userId, String logdate,String topic , double hourspent,String notes){
        this.userId=userId;
        this.logdate=logdate;
        this.topic=topic;
        this.hourspent=hourspent;
        this.notes=notes;

    }
   public  DailyLog(){}
public double getHourspent() {
    return hourspent;
}
public String getLogdate() {
    return logdate;
}

public String getNotes() {
    return notes;
}
public String getTopic() {
    return topic;
}
public int getUserId() {
    return userId;
}
public void setHourspent(double hourspent) {
    this.hourspent = hourspent;
}
public void setLogdate(String logdate) {
    this.logdate = logdate;
}
public void setNotes(String notes) {
    this.notes = notes;
}
public void setTopic(String topic) {
    this.topic = topic;
}
public void setUserId(int userId) {
    this.userId = userId;
}


    
}
