import React from 'react';
import StudentForm from '../components/StudentForm';

function AddStudent() {
  const handleAddStudent = async (formData) => {
    console.log('Adding student:', formData);
    // API call would go here
  };

  return (
    <div className="add-student-page">
      <StudentForm onSubmit={handleAddStudent} />
    </div>
  );
}

export default AddStudent;
