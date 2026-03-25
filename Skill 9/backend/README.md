# Backend - Student Management System API

Spring Boot REST API implementing Global Exception Handling using `@ControllerAdvice`.

## 📌 Overview

This backend provides a RESTful API for student management with centralized exception handling and structured error responses.

## 🛠️ Tech Stack

- **Java:** 21
- **Spring Boot:** 3.2.0
- **Build Tool:** Maven
- **Server:** Apache Tomcat 10.1.16
- **Dependencies:** Lombok, Spring Web

## 📦 Project Structure

```
src/main/java/com/example/studentmanagement/
│
├── StudentManagementApplication.java    # Main entry point
│
├── controller/
│   ├── StudentController.java           # REST API endpoints
│   └── WelcomeController.java           # Welcome endpoint
│
├── service/
│   └── StudentService.java              # Business logic & dummy data
│
├── model/
│   └── Student.java                     # Student entity (id, name, department)
│
└── exception/
    ├── StudentNotFoundException.java     # Custom 404 exception
    ├── InvalidInputException.java       # Custom 400 exception
    ├── GlobalExceptionHandler.java      # @ControllerAdvice handler
    └── ErrorResponse.java               # Error response DTO
```

## 🚀 Getting Started

### Prerequisites
- Java 21+
- Maven 3.6+

### Installation

```bash
cd backend
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

Application starts on: **http://localhost:8080**

## 🔌 API Endpoints

| Method | Endpoint | Status | Description |
|--------|----------|--------|-------------|
| GET | `/` | 200 | Welcome message |
| GET | `/student/{id}` | 200/404/400 | Get student by ID |
| GET | `/students` | 200 | Get all students (future) |
| POST | `/students` | 200 | Create student (future) |

## 📊 Dummy Data

```
ID: 1  → Name: Sai    → Department: CSE
ID: 2  → Name: Rahul  → Department: ECE
ID: 3  → Name: Priya  → Department: IT
```

## 🧪 Test Examples

### ✅ Valid Request (200)
```bash
GET http://localhost:8080/student/1

Response:
{
  "id": 1,
  "name": "Sai",
  "department": "CSE"
}
```

### ❌ Student Not Found (404)
```bash
GET http://localhost:8080/student/99

Response:
{
  "timestamp": "2026-03-14T15:31:37",
  "message": "Student not found with ID: 99",
  "statusCode": 404
}
```

### ❌ Invalid Input Format (400)
```bash
GET http://localhost:8080/student/abc

Response:
{
  "timestamp": "2026-03-14T15:31:37",
  "message": "Invalid input: Student ID must be a valid number. Received: abc",
  "statusCode": 400
}
```

## ⚙️ Configuration

**application.properties:**
```properties
spring.application.name=student-management-system
server.port=8080
```

## 🔑 Key Classes

### StudentController
- `@RestController` with `@RequestMapping("/student")`
- `GET /{id}` endpoint with validation
- Throws `StudentNotFoundException` for missing students
- Throws `InvalidInputException` for invalid input

### GlobalExceptionHandler
- `@ControllerAdvice` for centralized exception handling
- `@ExceptionHandler` methods for each exception type
- Returns structured `ErrorResponse` with timestamp, message, statusCode

### StudentService
- In-memory student database
- Methods: `getStudentById()`, `studentExists()`
- Dummy data initialization in constructor

## 📝 Error Handling

| Exception | Status | Message |
|-----------|--------|---------|
| StudentNotFoundException | 404 | Student not found with ID: {id} |
| InvalidInputException | 400 | Invalid input: {reason} |

## 🧬 Dependencies

```xml
<!-- Spring Boot Web Starter -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- Spring Boot DevTools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

## 📚 API Testing

Use the provided Postman collection: `Student_Management_API.postman_collection.json`

Or test with curl:
```bash
curl -X GET http://localhost:8080/student/1
```

## 🐛 Troubleshooting

**Port 8080 already in use:**
```bash
# Change port in application.properties
server.port=8081
```

**Build errors:**
```bash
mvn clean cache:clean install
```

## 📖 Documentation

For frontend setup, see [../frontend/README.md](../frontend/README.md)

For full project overview, see [../README.md](../README.md)

---

**Status:** ✅ Production Ready
