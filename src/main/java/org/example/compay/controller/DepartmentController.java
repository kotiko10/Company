package org.example.compay.controller;

import org.example.compay.exception.ResourceNotFoundException;
import org.example.compay.model.Department;
import org.example.compay.model.Employee;
import org.example.compay.repository.DepartmentRepository;
import org.example.compay.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/CompanyApi/v1/")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }
    @PutMapping("/{departmentId}/head/{employeeId}")
    public ResponseEntity<Department> updateDepartmentHead(
            @PathVariable Long departmentId,
            @PathVariable Long employeeId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

        Employee newHead = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        department.setHead(newHead);
        Department updatedDepartment = departmentRepository.save(department);

        return ResponseEntity.ok(updatedDepartment);
    }
}
