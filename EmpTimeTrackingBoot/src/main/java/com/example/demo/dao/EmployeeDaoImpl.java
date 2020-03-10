package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeVO;
import com.example.demo.model.utility.Converter;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplateObj;

	@Override
	public Employee save(EmployeeVO empVO) 
	{
		Employee emp = new Employee();
		int count = 0;
		
        String sqlSelectQuery = "SELECT * FROM employee where emp_id= "+empVO.getEmpId();
        //int count = jdbcTemplateObj.queryForInt(sqlSelectQuery);
        List empList = jdbcTemplateObj.queryForList(sqlSelectQuery,Employee.class);
        if(!empList.isEmpty())
             count = empList.size();
        if(count==0)
        {
        	String sqlInsertQuery = "INSERT INTO employee (emp_id, emp_name,designation) VALUES (?, ?, ?)";
	        jdbcTemplateObj.update(sqlInsertQuery,empVO.getEmpId(),empVO.getEmpName(),empVO.getDesignation() );
	    }
        
        String dateTimeInsertQuery = "INSERT INTO employee_hours (emp_id, swipe_in_time,swipe_out_time) VALUES (?, ?, ?)";
        jdbcTemplateObj.update(dateTimeInsertQuery,empVO.getEmpId(),empVO.getSwipeInTime(),empVO.getSwipeOutTime() );
        
        Employee empPojo = (Employee) Converter.convertToPojo(empVO,emp);
        return empPojo;

	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(int id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		
		 String sqlSelectQuery = "SELECT * FROM employee where emp_id= "+id;
		 Employee emp = jdbcTemplateObj.queryForObject(sqlSelectQuery,Employee.class);
		 if(!StringUtils.isEmpty(emp))
			 return emp;
		 else
			 throw new EmployeeNotFoundException("No employee found with given ID:"+ id);
	       
	}
	
	


	
	

	

}
