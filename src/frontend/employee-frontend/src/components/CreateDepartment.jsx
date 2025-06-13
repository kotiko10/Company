import React, { useState } from 'react';
import axios from 'axios';
import './CreateDepartment.css';
import { useNavigate } from 'react-router-dom';

function CreateDepartment() {
  const [name, setName] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const department = { name };

    try {
      await axios.post('http://localhost:8080/CompanyApi/v1/departments', department);
      alert('Department created successfully');
      navigate('/departments');
    } catch (error) {
      console.error(error);
      alert('Error creating department');
    }
  };

  return (
    <div className="create-department-container">
      <h2>Create New Department</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Department Name</label>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
            placeholder="Enter department name"
          />
        </div>
        <button type="submit">Create Department</button>
      </form>
    </div>
  );
}

export default CreateDepartment;
