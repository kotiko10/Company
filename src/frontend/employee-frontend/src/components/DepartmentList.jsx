import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './DepartmentList.css';

function DepartmentList() {
  const [departments, setDepartments] = useState([]);
  const [employees, setEmployees] = useState([]);
  const [selectedHeads, setSelectedHeads] = useState({});

  useEffect(() => {
    fetchDepartments();
    fetchEmployees();
  }, []);

  const fetchDepartments = async () => {
    const res = await axios.get('http://localhost:8080/CompanyApi/v1/departments');
    setDepartments(res.data);
  };

  const fetchEmployees = async () => {
    const res = await axios.get('http://localhost:8080/CompanyApi/v1/employees');
    setEmployees(res.data);
  };

  const handleHeadChange = (deptId, empId) => {
    setSelectedHeads({ ...selectedHeads, [deptId]: empId });
  };

  const updateHead = async (deptId) => {
    const empId = selectedHeads[deptId];
    if (!empId) return alert("Please select an employee.");

    try {
      await axios.put(`http://localhost:8080/CompanyApi/v1/${deptId}/head/${empId}`);
      alert('Head updated successfully');
      fetchDepartments();
    } catch (error) {
      alert('Error updating department head');
      console.error(error);
    }
  };

  return (
    <div className="department-container">
      <h2>Department List</h2>
      <table className="department-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Current Head</th>
            <th>Change Head</th>
          </tr>
        </thead>
        <tbody>
          {departments.map(dept => (
            <tr key={dept.id}>
              <td>{dept.id}</td>
              <td>{dept.name}</td>
              <td>{dept.head ? `${dept.head.firstName} ${dept.head.lastName}` : 'None'}</td>
              <td>
                <select
                  onChange={(e) => handleHeadChange(dept.id, e.target.value)}
                  defaultValue=""
                >
                  <option value="">-- Select Employee --</option>
                  {employees.map(emp => (
                    <option key={emp.id} value={emp.id}>
                      {emp.firstName} {emp.lastName}
                    </option>
                  ))}
                </select>
                <button onClick={() => updateHead(dept.id)}>Update</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default DepartmentList;
