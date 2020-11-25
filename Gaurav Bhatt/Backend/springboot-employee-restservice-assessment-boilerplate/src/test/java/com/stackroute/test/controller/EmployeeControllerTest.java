package com.stackroute.test.controller;

import com.stackroute.controller.EmployeeController;
import com.stackroute.exceptions.EmployeeAlreadyExistException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import com.stackroute.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }
    @Test
    public void givenNewEmployeeWhenPostThenReturnEmployeeJSON() throws Exception {
        Employee employee = new Employee(100,"Prasad","Accounts","Chennai");
        when(employeeService.addNew(any())).thenReturn(employee);
        mockMvc.perform(post("/api/v1/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":100,\"firstName\":\"Prasad\",\"departments\":\"Accounts\",\"workLocation\":\"Chennai\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(100));
    }

    @Test
    public void givenDuplicateEmployeeWhenPostThenReturnErrorMessage() throws Exception {
        when(employeeService.addNew(any())).thenThrow(EmployeeAlreadyExistException.class);
        mockMvc.perform(post("/api/v1/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":100,\"firstName\":\"Prasad\",\"departments\":\"Accounts\",\"workLocation\":\"Chennai\"}"))
                .andExpect(status().isConflict())
                .andExpect(content().string("Employee already Exist"));
    }

    @Test
    public void givenValidEmployeeIDWhenGETThenReturnEmployee() throws Exception {
        Employee employee = new Employee(100,"Prasad","Accounts","Chennai");
        when(employeeService.getById(anyInt())).thenReturn(employee);
        mockMvc.perform(get("/api/v1/employees/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(100));
    }

    @Test
    public void givenInValidEmployeeIDWhenGETThenReturnErrorMessage() throws Exception {

        when(employeeService.getById(anyInt())).thenThrow(EmployeeNotFoundException.class);
        mockMvc.perform(get("/api/v1/employees/100"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Employee Not found"));
    }
}