package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DailyLogDAO {
    public  void deleteLog(int id) {
    String query = "DELETE FROM daily_log WHERE id = ?";
    
    try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setInt(1, id);
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("daily log deleted successfully!");
        } else {
            System.out.println("No daily log found with id: " + id);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public List<DailyLog> getAllLogs(){
        List<DailyLog> list = new ArrayList<>();

    String query = "SELECT * FROM daily_log";

    try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int user_id=rs.getInt("user_id");
             String logdate=rs.getString("log_date");
             String topic=rs.getString("topic");
             double hoursspent = rs.getDouble("hours_spent");
             String  notes= rs.getString("notes");
             
           list.add(new DailyLog(user_id, logdate, topic, hoursspent, notes));

          
                 
         }
  

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
    }
    public void addLog(DailyLog log){
        String query = "INSERT INTO daily_log(user_id,log_date,topic,hours_spent,notes) VALUES (?, ?, ?, ? , ? )";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, log.getUserId());
            ps.setString(2, log.getLogdate());
            ps.setString(3, log.getTopic());
            ps.setDouble(4, log.getHourspent());
             ps.setString( 5,log.getNotes());
           

            ps.executeUpdate();
            System.out.println("Daily Log added successfully!");
            
            
}

 

         catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
