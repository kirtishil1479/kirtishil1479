package com.kjd.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjd.model.Employee;
import com.kjd.service.EmpServiceImpl;

@RestController
public class controller {
  
	private EmpServiceImpl empServiceImpl;

	public controller(EmpServiceImpl empServiceImpl) {
		super();
		this.empServiceImpl = empServiceImpl;
	}
	
	//Build create Employee REST API
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee( @RequestBody   Employee employee){
		return new ResponseEntity<>(empServiceImpl.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	
	// Get All Employee REST API
	@GetMapping("/getAllEmployeesDetails")
	public List<Employee> getEmployees(){
		List<Employee> emplist = empServiceImpl.getEmployee();
		
		return emplist ;
		}
	
	//Get employee By Id REST API
	
	@GetMapping("/EmployeeFindById/{id}")
	public ResponseEntity<Employee> FindById( @PathVariable  int id){
		Employee empById = empServiceImpl.getEmpById(id);
		
		return new ResponseEntity<Employee>(empById,HttpStatus.OK );
	}
	
	
	//Update Employee REST API
	
	@PutMapping("/upadateEmployeeData/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
		Employee update = empServiceImpl.updateemployee(employee, id);
		return update;
		}
	
	// Delete Employee REST API
	@DeleteMapping("/deleteEmployeebyId/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		
		empServiceImpl.deleteEmployee(id);
		String msg="Employee Deleted Succesfully";
		return new  ResponseEntity<>(msg,HttpStatus.OK);
		
		
	}
	
	
}
