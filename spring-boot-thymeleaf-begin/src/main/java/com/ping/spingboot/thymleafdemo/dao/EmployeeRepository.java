package com.ping.spingboot.thymleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ping.spingboot.thymleafdemo.entity.Employee;



//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//No need to implement the body
	
	//add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
