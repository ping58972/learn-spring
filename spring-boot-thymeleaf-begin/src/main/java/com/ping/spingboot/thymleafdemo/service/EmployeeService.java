package com.ping.spingboot.thymleafdemo.service;
//
import java.util.List;

import com.ping.spingboot.thymleafdemo.entity.Employee;



public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee thEmployee);
	
	public void deleteById(int theId);
}
