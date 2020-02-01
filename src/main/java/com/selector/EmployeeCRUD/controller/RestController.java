package com.selector.EmployeeCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.selector.EmployeeCRUD.dao.EmployeeRepository;
import com.selector.EmployeeCRUD.entity.Employee;
import com.selector.EmployeeCRUD.service.EmployeeService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/jpa")
public class RestController {
	
	@Autowired
	private EmployeeService employeeService ;
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		
		List<Employee> employees = employeeService.findAll();
		return employees ;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee not founded " + employeeId);
		}
		return employee ;
	}
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) { 
		employeeService.save(employee);
		return employee;
	}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null ) {
			throw new RuntimeException("employee " + employeeId + " not founded");
		}
		employeeService.deleteById(employeeId);
		return "Emplyee deleted" + employeeId ;
		
	}
}
