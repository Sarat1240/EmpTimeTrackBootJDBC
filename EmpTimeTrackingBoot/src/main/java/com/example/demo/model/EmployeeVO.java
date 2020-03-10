package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeVO {
	
   private long empId;
   @NotNull(message = "Name should not be empty")
   private String empName;
   private String designation;
   @DateTimeFormat
   private Date swipeInTime;
   private Date swipeOutTime;
   private String location;
		   
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getSwipeInTime() {
		return swipeInTime;
	}
	public void setSwipeInTime(Date swipeInTime) {
		this.swipeInTime = swipeInTime;
	}
	public Date getSwipeOutTime() {
		return swipeOutTime;
	}
	public void setSwipeOutTime(Date swipeOutTime) {
		this.swipeOutTime = swipeOutTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
