package com.example.demo.dao;

import java.util.List;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeVO;

public interface EmployeeDAO {
	
	public Employee save(EmployeeVO emp);
	public List<Employee> list();
	public Employee getEmployee(int id) throws EmployeeNotFoundException;


}
