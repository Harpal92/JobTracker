package Jobtracker.demo.src.main.java.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Jobtracker.demo.src.main.java.com.example.DBconnection;
import Jobtracker.demo.src.main.java.com.example.JobApplication;

public class JobApplicationDAO {
   public void deleteJob(int id) {
    String query = "DELETE FROM job_application WHERE id = ?";
    
    try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setInt(1, id);
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Job deleted successfully!");
        } else {
            System.out.println("No job found with id: " + id);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
   public void updateStatus(int id, String status){
      String query = "UPDATE job_application SET status = ? WHERE id = ?";
      try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query);
        
          )
          {       
                       ps.setString(1, status); 
                       ps.setInt(2, id);     
                        ps.executeUpdate();
        
  
        System.out.println("Status updated!");
    } catch (Exception e) {
        e.printStackTrace();
    }
   }
   
   public List<JobApplication>  getJobsByStatus(String status){
      List<JobApplication> list = new ArrayList<>();

    String query = "SELECT * FROM job_application WHERE status = ?";

    try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query) ) {
        ps.setString(1, status);
         ResultSet rs = ps.executeQuery();
          
                       
        while (rs.next()) {
             String companyname=rs.getString("company_name");
             String role=rs.getString("role");
             String apply_date = rs.getString("apply_date");
             String  test_date= rs.getString("test_date");
             String Status = rs.getString("status");
             int user_id=rs.getInt("user_id");
             list.add(new JobApplication(companyname, role, apply_date, test_date, status, user_id));

           
                 
         }
  

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
   }
   public List<JobApplication>  getAllJobs() {
      List<JobApplication> list = new ArrayList<>();

    String query = "SELECT * FROM job_application";

    try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
             String companyname=rs.getString("company_name");
             String role=rs.getString("role");
             String apply_date = rs.getString("apply_date");
             String  test_date= rs.getString("test_date");
             String status = rs.getString("status");
             int user_id=rs.getInt("user_id");
             list.add(new JobApplication(companyname, role, apply_date, test_date, status, user_id));

          //  System.out.println(companyname + " " + role + " " + apply_date + " " +test_date + " " + status + " " + user_id);
                 
         }
  

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

   public void addJobApplication(JobApplication job) {

        String query = "INSERT INTO job_application(company_name, role ,apply_date,test_date,status,user_id) VALUES (?, ?, ?, ? , ? , ?)";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, job.getCompanyname());
            ps.setString(2, job.getRole());
            ps.setString(3, job.getApplydate());
            ps.setString(4, job.getTestdate());
            ps.setString(5,job.getStatus());
            ps.setInt(6,job.getUserId());

            ps.executeUpdate();
            System.out.println("Job Application inserted!");
            
            
}

 

         catch (Exception e) {
            e.printStackTrace();
        }
       
   }
}
