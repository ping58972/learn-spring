//package com.ping.springboot.cruddemo.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.ui.context.Theme;
//
//import com.ping.springboot.cruddemo.entity.Employee;
//
//@Repository
//public class EmployeeDAOJpaImpl implements EmployeeDAO {
//
//	private EntityManager entityManager;
//	
//	@Autowired
//	public EmployeeDAOJpaImpl(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
//
//	@Override
//	public List<Employee> findAll() {
//		//create a query
//		Query theQuery = entityManager.createQuery("from Employee");
//		//excute query and get result list
//		List<Employee> employees = theQuery.getResultList();
//		//return The result;
//		return employees;
//	}
//
//	@Override
//	public Employee findById(int theId) {
//		// get employee
//		Employee thEmployee = entityManager.find(Employee.class, theId);
//		return thEmployee;
//	}
//
//	@Override
//	public void save(Employee thEmployee) {
//		// update with id from db ... so we can get fenerated id for save/insert
//		Employee dbEmployee = entityManager.merge(thEmployee);
//		thEmployee.setId(dbEmployee.getId());
//
//	}
//
//	@Override
//	public void deleteById(int theId) {
//		// delete object by primary key
//		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
//		theQuery.setParameter("employeeId", theId);
//		theQuery.executeUpdate();
//
//	}
//
//}
