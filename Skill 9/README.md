# Student Management System

A full-stack web application for managing student information with Global Exception Handling using Spring Boot and React.

## 🎯 Project Overview

This project implements **Skill 9: Global Exception Handling using @ControllerAdvice** with:
- Spring Boot Backend (Java 21)
- React Frontend (JavaScript)
- RESTful API with centralized exception handling
- Clean error responses with timestamp, message, and status codes

## ✨ Features

- ✅ RESTful API for student management
- ✅ Global exception handling with `@ControllerAdvice`
- ✅ Custom exceptions (StudentNotFoundException, InvalidInputException)
- ✅ Structured JSON error responses (timestamp, message, statusCode)
- ✅ Proper HTTP status codes (200, 404, 400)
- ✅ Input validation (numeric, positive numbers)
- ✅ React frontend with interactive UI
- ✅ Dummy student data (Sai, Rahul, Priya)
- ✅ Lombok annotations for cleaner code

## Project Structure

```
src/main/java/com/example/studentmanagement/
├── controller/
│   └── StudentController.java
├── exception/
│   ├── StudentNotFoundException.java
│   ├── InvalidInputException.java
│   ├── ErrorResponse.java
│   └── GlobalExceptionHandler.java
├── model/
│   └── Student.java
├── service/
│   └── StudentService.java
└── StudentManagementApplication.java
```

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Installation & Setup

### 1. Clone or Navigate to Project

```bash
cd student-management-system
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` with context path `/api`.

## API Endpoints

### Get Student by ID

**Endpoint:** `GET /api/students/{id}`

**Example:** `http://localhost:8080/api/students/1`

## Test Scenarios

### Scenario 1: Valid Student ID (Success - 200)

**Request:**
```
GET http://localhost:8080/api/students/1
```

**Expected Response:**
```json
{
    "id": 1,
    "name": "Sai",
    "department": "CSE"
}
```

**Status Code:** `200 OK`

---

### Scenario 2: Student Not Found (Error - 404)

**Request:**
```
GET http://localhost:8080/api/students/5
```

**Expected Response:**
```json
{
    "timestamp": "2026-03-14T12:30:00",
    "message": "Student not found with ID: 5",
    "statusCode": 404
}
```

**Status Code:** `404 NOT FOUND`

---

### Scenario 3: Invalid Input - Text Instead of Number (Error - 400)

**Request:**
```
GET http://localhost:8080/api/students/abc
```

**Expected Response:**
```json
{
    "timestamp": "2026-03-14T12:30:45",
    "message": "Invalid input: Student ID must be a valid number. Received: abc",
    "statusCode": 400
}
```

**Status Code:** `400 BAD REQUEST`

---

### Scenario 4: Invalid Input - Negative ID (Error - 400)

**Request:**
```
GET http://localhost:8080/api/students/-5
```

**Expected Response:**
```json
{
    "timestamp": "2026-03-14T12:31:00",
    "message": "Invalid input: Student ID must be a positive number. Received: -5",
    "statusCode": 400
}
```

**Status Code:** `400 BAD REQUEST`

---

## Dummy Student Data

The application comes with the following dummy student records:

| ID | Name  | Department |
|----|-------|-----------|
| 1  | Sai   | CSE       |
| 2  | Rahul | ECE       |
| 3  | Priya | IT        |

## Postman Testing

### Import Collection

Use the following Postman requests:

```
1. GET {{base_url}}/api/students/1
2. GET {{base_url}}/api/students/2
3. GET {{base_url}}/api/students/3
4. GET {{base_url}}/api/students/5 (Not Found)
5. GET {{base_url}}/api/students/abc (Invalid Input)
6. GET {{base_url}}/api/students/-1 (Invalid Input)
7. GET {{base_url}}/api/students/xyz (Invalid Input)
```

Replace `{{base_url}}` with `http://localhost:8080/api`

## Project Components

### 1. Student Model
- Fields: `id`, `name`, `department`
- Uses Lombok `@Data` for getters/setters

### 2. StudentService
- Contains business logic
- Maintains dummy student database
- Provides student lookup functionality

### 3. StudentController
- REST endpoints
- Input validation
- Throws appropriate exceptions

### 4. Custom Exceptions
- `StudentNotFoundException`: Thrown when student ID doesn't exist
- `InvalidInputException`: Thrown when input validation fails

### 5. GlobalExceptionHandler (@ControllerAdvice)
- Centralized exception handling
- Converts exceptions to JSON responses
- Returns appropriate HTTP status codes

### 6. ErrorResponse
- Structured error response format
- Fields: `timestamp`, `message`, `statusCode`

## Key Concepts Demonstrated

### @ControllerAdvice
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(...) {
        // Handle exception
    }
}
```

### @ExceptionHandler
Annotations to handle specific exceptions and return custom responses.

### Custom Exceptions
Runtime exceptions that extend `RuntimeException` for specific error scenarios.

### Input Validation
String to numeric conversion with error handling.

### HTTP Status Codes
- `200 OK`: Successful request
- `400 BAD REQUEST`: Invalid input
- `404 NOT FOUND`: Resource not found
- `500 INTERNAL SERVER ERROR`: Server error

## Dependencies

- Spring Boot 3.2.0
- Spring Web
- Lombok
- JUnit 5 (for testing)

## Maven Commands

```bash
# Build the project
mvn clean build

# Run tests
mvn test

# Start the application
mvn spring-boot:run

# Package as JAR
mvn clean package

# Run the JAR
java -jar target/student-management-system-1.0.0.jar
```

## Troubleshooting

### Port Already in Use
If port 8080 is already in use, change it in `application.properties`:
```properties
server.port=8888
```

### Maven Build Issues
```bash
# Clear Maven cache
mvn clean

# Rebuild
mvn install
```

### IntelliJ IDEA Issues
- Invalidate caches and restart
- Rebuild project: Build → Rebuild Project

## Best Practices Implemented

✅ Centralized exception handling using `@ControllerAdvice`  
✅ Custom exceptions for specific error scenarios  
✅ Structured error response format  
✅ Proper use of HTTP status codes  
✅ Input validation before processing  
✅ Lombok for reducing boilerplate code  
✅ Service layer separation of concerns  
✅ RESTful API design  
✅ Meaningful error messages  

## Future Enhancements

- Add database integration (JPA/Hibernate)
- Implement CRUD operations
- Add pagination and filtering
- Implement authentication/authorization
- Add comprehensive unit tests
- Add API documentation (Swagger/OpenAPI)
- Add logging with SLF4J

## Author

Created as a learning project for Spring Boot Global Exception Handling.

## License

MIT License - Feel free to use this project for learning purposes.

---

**Happy Coding!** 🚀
