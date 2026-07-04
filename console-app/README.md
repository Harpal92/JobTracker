# JobTracker - Console App

A console-based Java application for tracking job applications, tasks, and daily learning logs.

## Tech Stack
- Java 17
- MySQL
- Raw JDBC (no ORM)
- Maven
- BCrypt password hashing

## Features
- User registration and login with BCrypt password hashing
- Job Application tracking (Add, View, Filter by status, Update, Delete)
- Task management (Add, View, Update status, Delete)
- Daily learning log (Add, View, Delete)
- Stats and insights dashboard

## Database
MySQL database with 4 tables: users, job_application, task_table, daily_log

## How to Run
1. Create MySQL database `jobtracker`
2. Run the SQL schema to create tables
3. Update `DBconnection.java` with your MySQL credentials
4. Run `mvn exec:java -Dexec.mainClass="com.example.Main"`