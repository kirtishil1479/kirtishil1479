package com.kjd.service;

import java.util.List;

import com.kjd.model.Employee;

public interface EmpServiceI {
	
	public Employee saveEmployee(Employee emp);
	public List<Employee> getEmployee();
	public Employee getEmpById(int id);
	public Employee updateemployee(Employee employee , int id);
	public void deleteEmployee(int id);

}
