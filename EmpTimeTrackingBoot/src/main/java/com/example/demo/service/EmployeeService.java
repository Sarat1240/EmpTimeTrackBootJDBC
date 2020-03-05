package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeVO;

public interface EmployeeService {
	
	Employee save(EmployeeVO emp);
	List<Employee> list();

}




