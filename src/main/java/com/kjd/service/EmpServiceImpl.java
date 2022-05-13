package com.kjd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kjd.Repository.EmployeeRepository;
import com.kjd.exception.ResourseNotFoundException;
import com.kjd.model.Employee;

@Service
public class EmpServiceImpl implements EmpServiceI{
	
	private EmployeeRepository employeeRepository;
	
    public EmpServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee emp) {
		
		return employeeRepository.save(emp);
	}


	@Override
	public List<Employee> getEmployee() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}


	@Override
	public Employee getEmpById(int id) {
		 Optional<Employee> byId = employeeRepository.findById(id);
	
	 if(byId.isPresent()) {
		 return byId.get();
	 }else {
		 throw new ResourseNotFoundException("Employee","Id",id);
	 }
	}


	@Override
	public Employee updateemployee(Employee employee, int id) {
		//first we have to check given employee is available or not in db
		
		Employee exixtingemp = employeeRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Employee","Id",id));
		
		
		exixtingemp.setName(employee.getName());
		exixtingemp.setCity(employee.getCity());
		exixtingemp.setSalary(employee.getSalary());
		
		Employee update = employeeRepository.save(exixtingemp);
		return exixtingemp;
	}


	@Override
	public void deleteEmployee(int id) {
		// Check weither a employee existing in db or not
		
		employeeRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Employee","Id",id));
		new ResourseNotFoundException("Employee","Id",id);
		
		employeeRepository.deleteById(id);
		
	}

}
