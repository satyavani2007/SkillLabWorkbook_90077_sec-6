import React from 'react';
import StudentList from '../components/StudentList';

function Home() {
  return (
    <div className="home-page">
      <h2>Welcome to Student Management System</h2>
      <StudentList />
    </div>
  );
}

export default Home;
