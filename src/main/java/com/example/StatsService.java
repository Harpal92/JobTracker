package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StatsService {
   
    public static void showStats() {
        System.out.println("========== YOUR STATS ==========");
        String query;
        int applied = 0;
        int pending = 0;
        double spent = 0.0;
       
         query = "SELECT COUNT(*) FROM job_application";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int total = rs.getInt(1);
                System.out.println("Total Applications : " + total);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         query = "SELECT COUNT(*) FROM job_application WHERE status = 'Applied'";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                 applied = rs.getInt(1);
                System.out.println(" Applied Applications : " + applied);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         query = "SELECT COUNT(*) FROM job_application WHERE status = 'Interview'";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int interview = rs.getInt(1);
                System.out.println(" Interview : " + interview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         query = "SELECT COUNT(*) FROM job_application WHERE status = 'Rejected'";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int rejected = rs.getInt(1);
                System.out.println(" Rejected Application : " + rejected);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         query = "SELECT COUNT(*) FROM job_application WHERE status = 'Offer'";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int offer= rs.getInt(1);
                System.out.println("  Job Offer : " + offer);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        query = "SELECT COUNT(*) FROM  task_table ";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int task = rs.getInt(1);
                System.out.println("  Total Task : " + task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         query = "SELECT COUNT(*) FROM  task_table WHERE status = 'Completed' ";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int completetask = rs.getInt(1);
                System.out.println("  Completed Task : " + completetask);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         query = "SELECT COUNT(*) FROM  task_table WHERE status =  'Pending' ";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                 pending = rs.getInt(1);
                System.out.println("  Pending Task : " + pending);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         query = "SELECT SUM(hours_spent) FROM daily_log ";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                 spent = rs.getDouble(1);
                System.out.println("  Hours Spent: " + spent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          query = "SELECT COUNT(DISTINCT topic) FROM daily_log ";
        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int topic = rs.getInt(1);
                System.out.println("  Distinct Topic: " + topic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(applied >0) System.out.println("consider following up!");
        if(pending>0) System.out.println("stay focused!");
        if(spent>0)System.out.println("keep going!");
        if(spent==0)System.out.println("bro pls do study");
    }
}