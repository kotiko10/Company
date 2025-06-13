package org.example.compay;

import org.example.compay.exception.ResourceNotFoundException;
import org.example.compay.model.Department;
import org.example.compay.model.Employee;
import org.example.compay.repository.DepartmentRepository;
import  org.example.compay.controller.DepartmentController;
import org.example.compay.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private DepartmentController departmentController;

    @Test
    void testGetAllDepartments() {
        when(departmentRepository.findAll()).thenReturn(List.of(new Department()));

        List<Department> result = departmentController.getAllDepartments();

        assertEquals(1, result.size());
        verify(departmentRepository, times(1)).findAll();
    }

    @Test
    void testCreateDepartment() {
        Department department = new Department();
        department.setName("IT");

        when(departmentRepository.save(department)).thenReturn(department);

        Department result = departmentController.createDepartment(department);

        assertEquals("IT", result.getName());
    }

    @Test
    void testUpdateDepartmentHead_success() {
        Department department = new Department();
        department.setId(1L);
        Employee employee = new Employee();
        employee.setId(2L);

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        when(employeeRepository.findById(2L)).thenReturn(Optional.of(employee));
        when(departmentRepository.save(department)).thenReturn(department);

        ResponseEntity<Department> result = departmentController.updateDepartmentHead(1L, 2L);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(employee, result.getBody().getHead());
    }

    @Test
    void testUpdateDepartmentHead_departmentNotFound() {
        when(departmentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () ->
                departmentController.updateDepartmentHead(1L, 2L));
    }

    @Test
    void testUpdateDepartmentHead_employeeNotFound() {
        Department department = new Department();
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
        when(employeeRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () ->
                departmentController.updateDepartmentHead(1L, 2L));
    }
}
