package org.example.compay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.compay.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}