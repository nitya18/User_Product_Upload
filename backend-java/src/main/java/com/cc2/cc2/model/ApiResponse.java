package com.cc2.cc2.model;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse {
	
	public String firstName;
	public String validated;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getValidated() {
		return validated;
	}
	public void setValidated(String validated) {
		this.validated = validated;
	}
	
}
