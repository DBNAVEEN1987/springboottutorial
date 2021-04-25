package com.emp.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Address {
	private int id = 1;
	private String street = "Kempanna Layput";
	private String doorNo = "25";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

}
