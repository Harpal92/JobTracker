package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class TaskDAO { 
    public void updateTaskStatus(int id, String status){
      String query = "UPDATE task_table SET status = ? WHERE id = ?";
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
    public  void deleteTask(int id) {
    String query = "DELETE FROM task_table WHERE id = ?";
    
    try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setInt(1, id);
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("No Task found with id: " + id);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public List<Task>  getAllTasks() {
      List<Task> list = new ArrayList<>();

    String query = "SELECT * FROM task_table";

    try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
             String title=rs.getString("title");
             String description=rs.getString("description");
             String status = rs.getString("status");
             String  date= rs.getString("date");
             int user_id=rs.getInt("user_id");
            list.add(new Task(title, description, status, date, user_id));

          
                 
         }
  

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

    
public void addTask(Task task) {

        String query = "INSERT INTO task_table(title,description,status,date,user_id) VALUES (?, ?, ?, ? , ? )";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus());
            ps.setString(4, task.getDate());
             ps.setInt( 5,task.getUserId());
           

            ps.executeUpdate();
            System.out.println("Task added successfully!");
            
            
}

 

         catch (Exception e) {
            e.printStackTrace();
        }
       
   }
}

