import React from 'react';

function Navbar() {
  return (
    <nav className="navbar">
      <div className="container">
        <h1>Student Management System</h1>
        <ul className="nav-links">
          <li><a href="/">Home</a></li>
          <li><a href="/add">Add Student</a></li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;
