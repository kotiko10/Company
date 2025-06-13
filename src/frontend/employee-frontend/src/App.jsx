import React from 'react'
import { Routes, Route } from 'react-router-dom'
import EmployeeList from './components/EmployeeList'
import AddEmployee from './components/AddEmployee'
import EditEmployee from './components/EditEmployee'
import Navbar from './components/Navbar'

function App() {
  return (
    <div>
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/" element={<EmployeeList />} />
          <Route path="/add" element={<AddEmployee />} />
          <Route path="/edit/:id" element={<EditEmployee />} />
        </Routes>
      </div>
    </div>
  )
}

export default App
