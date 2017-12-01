package com.dbd.hackathon.model;

public class Members {

	private String name;
	private int empId;

	public Members(String name, int empId) {
		this.name = name;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public int getEmpId() {
		return empId;
	}

}
