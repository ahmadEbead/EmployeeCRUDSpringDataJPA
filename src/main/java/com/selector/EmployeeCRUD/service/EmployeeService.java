package com.selector.EmployeeCRUD.service;

import java.util.List;

import com.selector.EmployeeCRUD.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public Employee findById(int employeeId);
	public void save(Employee employee);
	public int deleteById(int employeeId);
	
}
