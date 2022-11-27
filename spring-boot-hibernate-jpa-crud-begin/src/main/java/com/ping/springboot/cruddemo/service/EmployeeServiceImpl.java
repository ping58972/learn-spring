//package com.ping.springboot.cruddemo.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
////import com.ping.springboot.cruddemo.dao.EmployeeDAO;
//import com.ping.springboot.cruddemo.dao.EmployeeRepository;
//import com.ping.springboot.cruddemo.entity.Employee;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
////	private EmployeeDAO employeeDAO; //for hibetnate with JPA
//	private EmployeeRepository employeeRepository; // for spring data JPA
//	
//	//for hibetnate with JPA
////	@Autowired
////	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")EmployeeDAO employeeDAO) {
////		this.employeeDAO = employeeDAO;
////	}
//	
//	// for spring data JPA
//	@Autowired
//	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
//		this.employeeRepository = theEmployeeRepository;
//	}
//
//	@Override
//	public List<Employee> findAll() {
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public Employee findById(int theId) {
//		Optional<Employee> result = employeeRepository.findById(theId);
//		
//		Employee theEmployee = null;
//		
//		if (result.isPresent()) {
//			theEmployee = result.get();
//		} else {
//			throw new RuntimeException("Did not find employee id - " + theId);
//		}
//		return theEmployee;
//	}
//
//	@Override
//	public void save(Employee thEmployee) {
//
//		employeeRepository.save(thEmployee);
//	}
//
//	@Override
//	public void deleteById(int theId) {
//		employeeRepository.deleteById(theId);
//	}
//
//}
