package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {
    public User login(String email, String password){
          User a = null;  
    String query = "SELECT * FROM users WHERE email = ? ";
 try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query) ) {
        ps.setString(1, email);
       

         ResultSet rs = ps.executeQuery();
          
                   
        while (rs.next()) {
             String storedHash = rs.getString("password");
 if (BCrypt.checkpw(password, storedHash)) {
             int id=rs.getInt("id");
             String name=rs.getString("name");
             String Email=rs.getString("email");
             
            
               a=new User(id,name, Email, null);
             System.out.println("Login successful");}
             else {
                System.out.println(" Password not match");
            }
             
             
    
    }
    
}
catch (Exception e) {
        e.printStackTrace();
    }
    return a;

    }
    public void getAllUsers() {
   
    String query = "SELECT * FROM users";

    try (Connection con = DBconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            System.out.println(id + " " + name + " " + email);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public int addUser(User user) {
         String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        String query = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, hashedPassword);

            ps.executeUpdate();
            System.out.println("User inserted!");
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
    int id = rs.getInt(1);
    return id;
}

 

        } catch (Exception e) {
            e.printStackTrace();
        }
       return -1; 
    }
}
