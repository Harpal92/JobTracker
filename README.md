<<<<<<< HEAD
# JobTracker - Spring Boot REST API

A REST API for tracking job applications, tasks, and daily learning logs.

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Security + JWT Authentication
- Spring Data JPA + Hibernate
- MySQL
- Maven

## Features
- User registration and login with BCrypt password hashing
- JWT token-based authentication
- Job Application tracking (Add, View, Update status, Delete)
- Task management (Add, View, Update status, Delete)
- Daily learning log (Add, View, Delete)
- Authorization - users can only access their own data

## API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /auth/register | Register new user |
| POST | /auth/login | Login and get JWT token |

### Job Applications (requires JWT)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /jobs/add | Add job application |
| GET | /jobs/get/{userId} | Get all jobs for user |
| PUT | /jobs/update/{id} | Update job status |
| DELETE | /jobs/delete/{id} | Delete job |

### Tasks (requires JWT)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /tasks/add | Add task |
| GET | /tasks/get/{userId} | Get all tasks for user |
| PUT | /tasks/update/{id} | Update task status |
| DELETE | /tasks/delete/{id} | Delete task |

### Daily Logs (requires JWT)
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /logs/add | Add daily log |
| GET | /logs/get/{userId} | Get all logs for user |
| DELETE | /logs/delete/{id} | Delete log |

## How to Run
1. Clone the repository
2. Create MySQL database `jobtracker`
3. Update `application.properties` with your MySQL credentials
4. Run `mvn spring-boot:run`
5. API runs on `http://localhost:8080`

## Authentication
After login, include the token in every request header:
```
Authorization: Bearer <your_token>
```
