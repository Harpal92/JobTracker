package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
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

        String query = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

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
