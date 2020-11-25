package com.stackroute.controller;

import com.stackroute.exceptions.EmployeeAlreadyExistException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import com.stackroute.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Annotate the class with @RestController and @RequestMapping */
@RequestMapping(value = "/api/v1")
public class EmployeeController {

    EmployeeService employeeService;

    /*
     * Constructor based Autowiring should be implemented
     */


    /*
     * Define a handler method to get all the Employees. This handler method should map to
     * the URL "/employees". This method will return the List of employees in the response body
     *  with the Httpstatus OK.
     */

    @GetMapping(value = "/employees")
    public ResponseEntity<?> getAllHandler() {
    }


    /*
     * Define a handler method to add a new Employee. This handler method should map to
     * the URL "/employees". This method will return the saved employee in the response body
     *  with the Httpstatus CREATED, if the employee is saved successfully, else, returns the message
     * "Employee already Exist" with the status CONFLICT.
     */
    @PostMapping(value = "/employees")
    public ResponseEntity<?> addNewHandler(@RequestBody Employee emp) {

    }


    /*
     * Define a handler method to add get an Employee by id. This handler method should map to
     * the URL "/employees/{id}". This method will return the retreived employee in the response body
     *  with the Httpstatus OK, if the employee is found, else, returns the message
     * "Employee Not found" with the status NOT_FOUND.
     */
    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<?> getByIdHandler(@PathVariable int id) {
    }
}
