package com.selector.EmployeeCRUD.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.selector.EmployeeCRUD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
