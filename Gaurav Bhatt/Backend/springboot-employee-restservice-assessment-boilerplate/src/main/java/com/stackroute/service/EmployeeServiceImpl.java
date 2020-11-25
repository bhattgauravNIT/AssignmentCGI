package com.stackroute.service;

import com.stackroute.dao.EmployeeRepository;
import com.stackroute.exceptions.EmployeeAlreadyExistException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Annotate the class with @Service Annotation */
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    /*
     * Constructor based Autowiring should be implemented
     */


    /*
     * This is method is used to get all the Employees
     */
    @Override
    public List<Employee> getAll() {

    }


    /*
     * This method is used to get an Employee by id.
     * The method should throw EmployeeNotFoundException, if the employee with the given id
     * is not found
     */
    @Override
    public Employee getById(int id) throws EmployeeNotFoundException {

    }


    /*
     * This method is used to save a new Employee.
     * The method should throw EmployeeAlreadyExistException, if the new employee that we are
     * trying save is already saved
     */
    @Override
    public Employee addNew(Employee emp) throws EmployeeAlreadyExistException {

    }
}
