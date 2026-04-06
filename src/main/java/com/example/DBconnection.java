package Jobtracker.demo.src.main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
  private static final String URL = "jdbc:mysql://localhost:3306/jobtracker";
    private static final String USER = "root";
    private static final String PASSWORD = "Your password here";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to DB!");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
