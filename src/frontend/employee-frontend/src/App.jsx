import React from 'react'
import { Routes, Route } from 'react-router-dom'
import EmployeeList from './components/EmployeeList'
import AddEmployee from './components/AddEmployee'
import EditEmployee from './components/EditEmployee'
import Navbar from './components/Navbar'
import DepartmentList from './components/DepartmentList';

function App() {
  return (
    <div>
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/" element={<EmployeeList />} />
          <Route path="/add" element={<AddEmployee />} />
          <Route path="/edit/:id" element={<EditEmployee />} />
          <Route path="/departments" element={<DepartmentList />} />
        </Routes>
      </div>
    </div>
  )
}

export default App
