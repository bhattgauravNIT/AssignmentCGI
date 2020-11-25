package com.stackroute.dao;

import com.stackroute.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/*
* Annotate the interface with @Repository and @Transactional
* extend the interface with JPARepository
* */
public interface EmployeeRepository {
}
