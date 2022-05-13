package com.kjd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kjd.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
