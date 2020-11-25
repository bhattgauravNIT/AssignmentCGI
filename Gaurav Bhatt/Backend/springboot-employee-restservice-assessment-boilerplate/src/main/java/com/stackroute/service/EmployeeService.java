package com.stackroute.service;

import com.stackroute.exceptions.EmployeeAlreadyExistException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    public List<Employee> getAll();
    public Employee getById(int id) throws EmployeeNotFoundException;
    public Employee addNew(Employee emp) throws EmployeeAlreadyExistException;
}
