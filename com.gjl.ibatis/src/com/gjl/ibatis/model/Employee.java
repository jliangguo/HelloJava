package com.gjl.ibatis.model;

public class Employee {

	private int employeeID;
	private String name;
	private String jobTitle;
	private String departmentName;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Employee:\nemployeeID=" + employeeID + "\nname=" + name
				+ "\njobTitle=" + jobTitle + "\ndepartmentName="
				+ departmentName + "\n";
	}
}
