package org.example.compay;

import org.example.compay.controller.EmployeeController;
import org.example.compay.exception.ResourceNotFoundException;
import org.example.compay.model.Employee;
import org.example.compay.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeControllerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee()));

        List<Employee> result = employeeController.getAllEmployees();

        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee("John", "Doe", "john@example.com");

        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeController.createEmployee(employee);

        assertEquals("John", result.getFirstName());
    }

    @Test
    void testGetEmployeeById_Success() {
        Employee employee = new Employee();
        employee.setId(1L);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        ResponseEntity<Employee> response = employeeController.getEmployeeById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testGetEmployeeById_NotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            employeeController.getEmployeeById(1L);
        });
    }

    @Test
    void testUpdateEmployee() {
        Employee existing = new Employee("John", "Doe", "john@example.com");
        existing.setId(1L);

        Employee update = new Employee("Jane", "Smith", "jane@example.com");

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(employeeRepository.save(any())).thenReturn(existing);

        ResponseEntity<Employee> response = employeeController.updateEmployee(1L, update);

        assertEquals("Jane", response.getBody().getFirstName());
        assertEquals("Smith", response.getBody().getLastName());
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        ResponseEntity<Map<String, Boolean>> response = employeeController.deleteEmployee(1L);

        assertTrue(response.getBody().get("deleted"));
        verify(employeeRepository).delete(employee);
    }
}