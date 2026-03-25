import React, { useEffect, useState } from 'react';
import StudentForm from '../components/StudentForm';

function UpdateStudent() {
  const [student, setStudent] = useState(null);

  useEffect(() => {
    // Fetch student data for update
  }, []);

  const handleUpdateStudent = async (formData) => {
    console.log('Updating student:', formData);
    // API call would go here
  };

  return (
    <div className="update-student-page">
      <StudentForm onSubmit={handleUpdateStudent} />
    </div>
  );
}

export default UpdateStudent;
