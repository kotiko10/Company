import React from 'react'
import { Link } from 'react-router-dom'

function Navbar() {
  return (
    <nav style={{ padding: '1rem', background: '#333', color: '#fff' }}>
      <Link to="/" style={{ color: '#fff', marginRight: '1rem' }}>Employee Manager</Link>
      <Link to="/add" style={{ color: '#0f0' }}>Add Employee</Link>
    </nav>
  )
}

export default Navbar
