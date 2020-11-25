# Objective
Complete the given Spring Boot Employee REST API, that use Spring Data JPA to interact with h2 in-memory database, by adding the missing code wherever required and submit within the alloted time.

# Complete the following as per the requirement
## Define Data Model - Employee Class  

Define the following properties in Employee Class. Properties should be private.
- id: int
- firstName: String
- department: String
- workLocation: String

Define parameterized constructor to initialize all the properties  
Define Getter and Setter for all the properties  

## Create Repository Interface  

In dao package, create EmployeeRepository interface that extends JPARepository  

## Create Service Class  

In service package, complete the EmployeeServiceImpl class by implementing the methods specified in the EmployeeService interface for providing the getAll, getById and addNew functionalities. These methods invokes the appropriate repository methods for interacting with the database and throws appropriate custom exceptions.   

## Create Employee Rest APIs Controller

In controller package, Complete the EmployeeController class that has the handler methods, for performing getAll, getById and addNew operations, mapped to appropriate URIs for RESTful requests.  

## APIs to be provided

| GET  	| /api/v1/employees      	| get all employees     	|
|------	|------------------------	|-----------------------	|
| GET  	| /api/v1/employees/{id} 	| get an employee by id 	|
| POST 	| /api/v1/employees      	| create a new employee 	|   
  

**Note:-** Read the instructions given as comments in the class files and also understand the failure messages displayed, when running the test cases, to complete the code.   
