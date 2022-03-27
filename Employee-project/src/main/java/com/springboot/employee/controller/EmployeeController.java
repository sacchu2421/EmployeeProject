package com.springboot.employee.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.Exception.EmployeeAlreadyExistException;
import com.springboot.employee.entity.Employee;
import com.springboot.employee.service.EmployeeCompare;
import com.springboot.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {


		@Autowired
		private EmployeeService service;
		
		@PostMapping("/AddEmployee")
		public Employee addEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExistException{
			return service.addEmployee(employee);
		}
		
		
		@GetMapping("/employees")
		public List<Employee> getEmployeesBySalaryDesc(){
			
			List<Employee> emplist=service.getEmployees();
			Collections.sort(emplist, new EmployeeCompare());
			return emplist;
		}
		
		@PutMapping("/update/{id}/{salary}")
		public Employee updateEmployeeById(@RequestBody Employee e, @PathVariable Integer id,@PathVariable Integer salary) {
			return service.updateEmployee(id,salary);
			
		}

	}



