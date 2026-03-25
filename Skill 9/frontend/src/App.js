import React, { useState, useEffect } from 'react';
import Navbar from './components/Navbar';
import StudentList from './components/StudentList';
import './App.css';

function App() {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      setLoading(true);
      const response = await fetch('http://localhost:8080/students');
      if (!response.ok) throw new Error('Failed to fetch students');
      const data = await response.json();
      setStudents(data);
      setError(null);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="App">
      <Navbar />
      <main className="container">
        {loading && <p>Loading students...</p>}
        {error && <p className="error">Error: {error}</p>}
        {!loading && !error && <StudentList students={students} />}
      </main>
    </div>
  );
}

export default App;
