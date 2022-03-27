package com.springboot.employee.Exception;

public class EmployeeAlreadyExistException extends Exception {
	public EmployeeAlreadyExistException() {
		
	}
	public EmployeeAlreadyExistException(String message) {
		super(message);
	}

}
