package com.selector.EmployeeCRUD.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selector.EmployeeCRUD.dao.EmployeeRepository;
import com.selector.EmployeeCRUD.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository ;
	
	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeRepository.findAll() ;
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {

		Optional<Employee> result = employeeRepository.findById(employeeId);
		Employee thEmployee = null;
		if (result.isPresent()) {
			thEmployee=result.get();
		}else {
			throw new RuntimeException("Employee dosent founded");
		}
		return thEmployee;
	}

	@Override
	@Transactional
	public void save(Employee employee) {

		employeeRepository.save(employee);

	}

	@Override
	@Transactional
	public int deleteById(int employeeId) {

		employeeRepository.deleteById(employeeId);
		return employeeId;
	}

}
