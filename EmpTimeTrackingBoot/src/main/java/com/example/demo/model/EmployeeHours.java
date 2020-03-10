package com.example.demo.model;

import java.util.Date;

public class EmployeeHours {
  
  private int empId;
  private Date swipeInTime;
  private Date swipeOutTime;
  	  
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	  
	  

}
