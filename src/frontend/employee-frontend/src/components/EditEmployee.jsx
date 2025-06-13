import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { useParams, useNavigate } from 'react-router-dom'

function EditEmployee() {
  const [employee, setEmployee] = useState({ firstName: '', lastName: '', emailId: '' })
  const { id } = useParams()
  const navigate = useNavigate()

  useEffect(() => {
    axios.get(`http://localhost:8080/CompanyApi/v1/employees/${id}`)
      .then(res => setEmployee(res.data))
  }, [id])

  const handleChange = (e) => {
    setEmployee({ ...employee, [e.target.name]: e.target.value })
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    await axios.put(`http://localhost:8080/CompanyApi/v1/employees/${id}`, employee)
    navigate('/')
  }

  return (
    <form onSubmit={handleSubmit}>
      <input name="firstName" value={employee.firstName} onChange={handleChange} required />
      <input name="lastName" value={employee.lastName} onChange={handleChange} required />
      <input name="emailId" value={employee.emailId} onChange={handleChange} required />
      <button type="submit">Update</button>
    </form>
  )
}

export default EditEmployee
