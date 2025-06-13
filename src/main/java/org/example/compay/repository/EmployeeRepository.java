package org.example.compay.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.example.compay.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
