import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import './EmployeeList.css'

function EmployeeList() {
  const [employees, setEmployees] = useState([])

  useEffect(() => {
    loadEmployees()
  }, [])

  const loadEmployees = async () => {
    const res = await axios.get('http://localhost:8080/CompanyApi/v1/employees')
    setEmployees(res.data)
  }

  const deleteEmployee = async (id) => {
    await axios.delete(`http://localhost:8080/CompanyApi/v1/employees/${id}`)
    loadEmployees()
  }

  return (
    <div>
      <h2>Employee List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Email</th>
            <th>First</th>
            <th>Last</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(emp => (
            <tr key={emp.id}>
              <td>{emp.id}</td>
              <td>{emp.emailId}</td>
              <td>{emp.firstName}</td>
              <td>{emp.lastName}</td>
              <td>
                <Link to={`/edit/${emp.id}`}>Edit</Link>
                <button onClick={() => deleteEmployee(emp.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default EmployeeList
