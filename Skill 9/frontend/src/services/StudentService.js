import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

const StudentService = {
  getStudents: async () => {
    try {
      const response = await axios.get(`${API_BASE_URL}/students`);
      return response.data;
    } catch (error) {
      throw error.response.data;
    }
  },

  getStudentById: async (id) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/student/${id}`);
      return response.data;
    } catch (error) {
      throw error.response.data;
    }
  },

  addStudent: async (student) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/students`, student);
      return response.data;
    } catch (error) {
      throw error.response.data;
    }
  },

  updateStudent: async (id, student) => {
    try {
      const response = await axios.put(`${API_BASE_URL}/students/${id}`, student);
      return response.data;
    } catch (error) {
      throw error.response.data;
    }
  },

  deleteStudent: async (id) => {
    try {
      await axios.delete(`${API_BASE_URL}/students/${id}`);
    } catch (error) {
      throw error.response.data;
    }
  }
};

export default StudentService;
