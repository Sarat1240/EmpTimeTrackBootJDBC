package com.example.demo.model.utility;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeVO;

public class Converter {
	
	public static Object convertToPojo(Object vo,Object pojo)
	{
		EmployeeVO empvo = (EmployeeVO)vo;
		Employee emppojo = (Employee)pojo;
		emppojo.setEmpId(empvo.getEmpId());
		emppojo.setEmpName(empvo.getEmpName());
		emppojo.setDesignation(empvo.getDesignation());
		return emppojo;
	}

}
