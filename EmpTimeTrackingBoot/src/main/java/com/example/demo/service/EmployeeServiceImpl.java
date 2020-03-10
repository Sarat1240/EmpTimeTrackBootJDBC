package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeVO;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO empDao;

	@Override
	public Employee save(EmployeeVO emp) {
		
		return empDao.save(emp);
	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Employee getEmployee(int id) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		return empDao.getEmployee(id);
	}
	
	
	
	
}
