package com.stackroute.test.service;

import com.stackroute.dao.EmployeeRepository;
import com.stackroute.exceptions.EmployeeAlreadyExistException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import com.stackroute.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;


    @Test
    public void givenValidEmployeeIDThenShouldReturnEmployee() throws EmployeeNotFoundException {
        Employee employee = new Employee(100,"Prasad","Accounts","Chennai");
        Optional<Employee> optionalEmployee = Optional.of(employee);
        when(employeeRepository.findById(100)).thenReturn(optionalEmployee);
        Employee retreivedEmployee = employeeService.getById(100);
        assertEquals(employee.getId(),retreivedEmployee.getId(),"should return employee for valid id of exixting employee");
    }

    @Test
    public void givenInValidEmployeeIDThenShouldThrowException() throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee = Optional.empty();
        when(employeeRepository.findById(100)).thenReturn(optionalEmployee);
        assertThrows(EmployeeNotFoundException.class,()->{employeeService.getById(100);});
    }

    @Test
    public void givenNewEmployeeWhenSavedShouldReturnEmployee() throws EmployeeAlreadyExistException {
        Employee employee = new Employee(100,"Prasad","Accounts","Chennai");
        Optional<Employee> optionalEmployee = Optional.empty();
        when(employeeRepository.findById(100)).thenReturn(optionalEmployee);
        Employee addedEmployee = employeeService.addNew(employee);
        verify(employeeRepository,times(1)).findById(100);
        verify(employeeRepository,times(1)).save(employee);
    }

    @Test
    public void givenDuplicateEmployeeWhenSavedShouldThrowException() throws EmployeeAlreadyExistException {
        Employee employee = new Employee(100,"Prasad","Accounts","Chennai");
        Optional<Employee> optionalEmployee = Optional.of(employee);
        when(employeeRepository.findById(100)).thenReturn(optionalEmployee);
        assertThrows(EmployeeAlreadyExistException.class,()->{employeeService.addNew(employee);});
        verify(employeeRepository,times(1)).findById(100);
        verify(employeeRepository,times(0)).save(employee);
    }
}