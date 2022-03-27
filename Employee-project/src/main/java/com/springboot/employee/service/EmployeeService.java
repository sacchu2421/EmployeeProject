package com.springboot.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employee.Exception.EmployeeAlreadyExistException;
import com.springboot.employee.entity.Employee;
import com.springboot.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;


	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Employee updateEmployee(int id ,int salary) {
		Employee existingEmployee = repository.findById(id).orElse(null);
	    existingEmployee.setSalary(salary);
		return repository.save(existingEmployee);
	}

	public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistException {
		if(repository.existsById(employee.getId())) {
			throw new EmployeeAlreadyExistException("Employee Id already exists kindly recheck");
		}
		else {
			return repository.save(employee);
	
		}
		
	}


}
