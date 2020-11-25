package com.stackroute.test.dao;

import com.stackroute.dao.EmployeeRepository;
import com.stackroute.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    public void givenNewEmployeeWhenSavedThenReturnEmployee(){
        Employee employee = new Employee(100,"Prasad","Accounts","Chennai");
        Employee adddedEmployee = employeeRepository.save(employee);
        assertEquals(employee.getId(),adddedEmployee.getId(), "New Employee should be saved and the same should be returned");
    }

    @Test
    public void givenInValidEmployeeIdThenReturnEmptyOptional(){
        assertTrue(employeeRepository.findById(100).isEmpty());
    }

    @Test
    public void givenValidEmployeeIdThenReturnEmployeeOptional(){
        Employee employee = new Employee(100,"Prasad","Accounts","Chennai");
        employeeRepository.save(employee);
        assertTrue(employeeRepository.findById(100).isPresent());
    }
}