# Frontend - Student Management System React App

React application for the Student Management System with API integration.

## 📌 Overview

Modern React frontend for managing student information with a clean, responsive UI.

## 🛠️ Tech Stack

- **React:** 18.2.0
- **Axios:** HTTP client
- **React Router:** Navigation
- **CSS:** Custom styling
- **Node.js:** 16+
- **npm:** 7+

## 📦 Project Structure

```
src/
│
├── components/
│   ├── StudentList.js     # Display students in table format
│   ├── StudentForm.js     # Form for adding/editing students
│   └── Navbar.js          # Navigation bar
│
├── pages/
│   ├── Home.js            # Home page
│   ├── AddStudent.js      # Add student page
│   └── UpdateStudent.js   # Update student page
│
├── services/
│   └── StudentService.js  # API communication layer
│
├── App.js                 # Main app component
├── App.css                # App styling
├── index.js               # React entry point
└── index.css              # Global styles

public/
└── index.html             # HTML template
```

## 🚀 Getting Started

### Prerequisites
- Node.js 16+
- npm 7+

### Installation

```bash
cd frontend
npm install
```

### Run Development Server

```bash
npm start
```

Application opens at: **http://localhost:3000**

### Build for Production

```bash
npm build
```

## 🔌 API Integration

### StudentService.js

Communicates with backend API at `http://localhost:8080`

```javascript
const API_BASE_URL = 'http://localhost:8080';

Methods:
- getStudents()                    // Get all students
- getStudentById(id)               // Get student by ID
- addStudent(student)              // Create new student
- updateStudent(id, student)       // Update student
- deleteStudent(id)                // Delete student
```

## 📊 Features

- ✅ View all students in table format
- ✅ Add new student
- ✅ Edit existing student
- ✅ Delete student
- ✅ Navigation bar with links
- ✅ Error handling
- ✅ Loading states
- ✅ Responsive design

## 🎨 Components

### StudentList
- Displays students in organized table
- Shows ID, Name, Department
- Action buttons for Edit/Delete

### StudentForm
- Form for adding/editing students
- Fields: Name, Department
- Form validation

### Navbar
- Navigation header
- Links to Home and Add Student pages
- Branding

## 🔧 Configuration

Backend API URL (in StudentService.js):
```javascript
const API_BASE_URL = 'http://localhost:8080';
```

Change this if backend runs on different port/host.

## 📦 Available Scripts

```bash
npm start       # Start development server
npm build       # Build for production
npm test        # Run tests
npm eject       # Eject from create-react-app
```

## 🐛 Troubleshooting

**CORS errors:**
- Ensure backend is running on port 8080
- Check backend's CORS configuration

**API not responding:**
```bash
# Verify backend is running
curl http://localhost:8080/student/1
```

**Port 3000 already in use:**
```bash
# Use different port
PORT=3001 npm start
```

## 📚 API Integration Example

```javascript
import StudentService from './services/StudentService';

// Fetch student
const student = await StudentService.getStudentById(1);
console.log(student);  // { id: 1, name: "Sai", department: "CSE" }

// Add student
const newStudent = { name: "John", department: "IT" };
await StudentService.addStudent(newStudent);

// Update student
await StudentService.updateStudent(1, { name: "Sai Kumar", department: "CSE" });

// Delete student
await StudentService.deleteStudent(1);
```

## 🌐 Backend API Reference

| Method | Endpoint | Response |
|--------|----------|----------|
| GET | `/student/1` | `{id, name, department}` |
| GET | `/student/99` | 404 Error |
| GET | `/student/abc` | 400 Error |
| POST | `/students` | Created student |
| PUT | `/students/1` | Updated student |
| DELETE | `/students/1` | Success message |

## 📖 Documentation

For backend setup, see [../backend/README.md](../backend/README.md)

For full project overview, see [../README.md](../README.md)

## 📝 Notes

- This is a skeleton implementation
- API methods are defined but not all are implemented
- Extend components as needed for full functionality
- Add error boundaries for better error handling
- Consider adding form validation libraries

---

**Status:** ✅ Ready for Development
