package com.jobtracker.jobtracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_application")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
private int userId;
    
    private String  role;
    @Column(name = "apply_date")
private String applydate;

@Column(name = "test_date")
private String testdate;

@Column(name = "company_name")
private String companyName;
     private  String status;
     public JobApplication(String CompanyName, String role, String applydate,String testdate, String status,int userId) {
        this.companyName = CompanyName;
        this.role = role;
        this.applydate = applydate;
        this.testdate=testdate;
        this.status=status;
        this.userId=userId;
    }
   public  JobApplication (){}
   public void setApplydate(String applydate) {
       this.applydate = applydate;
   }
   public void setCompanyName(String companyname) {
       this.companyName = companyname;
   }
   public void setRole(String role) {
       this.role = role;
   }
   public void setStatus(String status) {
       this.status = status;
   }
   public void setTestdate(String testdate) {
       this.testdate = testdate;
   }
   public void setUserId(int userId) {
       this.userId = userId;
   }
 
  public String getCompanyName() {
      return companyName;
  }
  public String getRole() {
      return role;
  }
   public String getApplydate() {
      return applydate;
  }
  public String getStatus() {
      return status;
  }
  public String getTestdate() {
      return testdate;
  }
  public int getUserId() {
    return userId;
}

}

