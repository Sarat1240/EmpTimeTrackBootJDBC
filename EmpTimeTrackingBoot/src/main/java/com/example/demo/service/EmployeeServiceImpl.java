package com.example.demo.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.config.AppConfig;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeVO;
import com.example.demo.model.utility.Converter;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
	
	JdbcTemplate jdbcTemplateObj =  new JdbcTemplate(AppConfig.getDatabaseConnection());

	@Override
	public Employee save(EmployeeVO empVO) 
	{
		Employee emp = null;
		
        String sqlSelectQuery = "SELECT * FROM employee where emp_id= ? "+empVO.getEmpId();
        //int count = jdbcTemplateObj.queryForInt(sqlSelectQuery);
        List empList = jdbcTemplateObj.queryForList(sqlSelectQuery,Employee.class);
        int count = empList.size();
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


	
	

	
	
	
}
