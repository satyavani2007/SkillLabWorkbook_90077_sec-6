import React, { useState } from 'react';

function StudentForm({ onSubmit }) {
  const [formData, setFormData] = useState({
    name: '',
    department: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
    setFormData({ name: '', department: '' });
  };

  return (
    <form onSubmit={handleSubmit} className="student-form">
      <h2>Add Student</h2>
      <div className="form-group">
        <label htmlFor="name">Name:</label>
        <input
          type="text"
          id="name"
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="department">Department:</label>
        <input
          type="text"
          id="department"
          name="department"
          value={formData.department}
          onChange={handleChange}
          required
        />
      </div>
      <button type="submit" className="btn-submit">Add Student</button>
    </form>
  );
}

export default StudentForm;
