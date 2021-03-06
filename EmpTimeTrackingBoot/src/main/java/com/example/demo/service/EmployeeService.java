package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeVO;

public interface EmployeeService {
	
	
	public Employee save(EmployeeVO emp);
	public List<Employee> list();
	public Employee getEmployee(int id) throws EmployeeNotFoundException;

}




