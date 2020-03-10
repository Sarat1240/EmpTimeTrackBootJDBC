package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeVO;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	
	@Autowired
	EmployeeService empservice;
	
	 @PostMapping("/employees")
	   public ResponseEntity<?> save(@Valid @RequestBody EmployeeVO empVO) {
			 
	      Employee emp1 = empservice.save(empVO);
	      return ResponseEntity.ok().body(" Employee has been saved with ID:" + emp1.getEmpId());
	   }
	 
	 @GetMapping("/employelist")
	 public ResponseEntity<List<Employee>> employeeList() {
	      List<Employee> empList = empservice.list();
	      return ResponseEntity.ok().body(empList);
	   }
	
	/*
	 * @PutMapping("/employelist") public ResponseEntity<List<Employee>>
	 * updateSwapeHours() { List<Employee> employe = empservice.list(); return
	 * ResponseEntity.ok().body(employe); }
	 */
	 
	 @GetMapping("/employee/{id}")
	 public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		 Employee emp = empservice.getEmployee(id);
	      return emp;
	   }
	

	
	
	
	
	
	
}
