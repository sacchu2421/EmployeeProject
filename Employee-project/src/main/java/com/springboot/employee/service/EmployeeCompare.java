package com.springboot.employee.service;

	import java.util.Comparator;

import com.springboot.employee.entity.Employee;

	public class EmployeeCompare implements Comparator<Employee> {
		public int compare(Employee e1,Employee e2) {
			if(e1.getSalary()==e2.getSalary()) {
				return e1.getName().compareTo(e2.getName());
		}
		else if(e1.getSalary()<e2.getSalary()) {
			return 1;
		}else {
			return -1;
		}
		
	}
	}
