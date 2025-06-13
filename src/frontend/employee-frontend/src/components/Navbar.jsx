import React from 'react';
import { NavLink } from 'react-router-dom';
import './Navbar.css';

function Navbar() {
  return (
    <nav className="navbar">
      <h1>Company Dashboard</h1>
      <div className="nav-links">
       <NavLink to="/" className={({ isActive }) => isActive ? 'active-link' : ''}>Employees</NavLink>
       <NavLink to="/add" className={({ isActive }) => isActive ? 'active-link' : ''}>Add Employee</NavLink>
       <NavLink to="/departments" className={({ isActive }) => isActive ? 'active-link' : ''}>Departments</NavLink>
       <NavLink to="/departments/create" className={({ isActive }) => isActive ? 'active-link' : ''}>Add Department</NavLink>

      </div>
    </nav>
  );
}

export default Navbar;