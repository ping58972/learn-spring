//package com.ping.springboot.cruddemo.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ping.springboot.cruddemo.entity.Employee;
//
//@Repository
//public class EmployeeDAOHibernateImpl implements EmployeeDAO {
//
//	//define field for entitymanager
//	private EntityManager entityManager;
//	
//	//set up constructor injection
//	@Autowired
//	public  EmployeeDAOHibernateImpl(EntityManager thEntityManager) {
//		entityManager = thEntityManager;
//	}
//	
//	@Override
//	public List<Employee> findAll() {
//		// get the current hibernate session
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//		// create a query
//		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
//		
//		// execute query and get result list
//		List<Employee> employees = theQuery.getResultList();
//		//return the result
//		
//		return employees;
//	}
//
//	@Override
//	public Employee findById(int theId) {
//		//get the current hibernate session
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//		//get the employee
//		Employee thEmployee = currentSession.get(Employee.class, theId);
//		
//		//return the employee
//		return thEmployee;
//	}
//
//	@Override
//	public void save(Employee thEmployee) {
//
//		//get the current hibernate session
//		Session curretnSession = entityManager.unwrap(Session.class);
//		curretnSession.saveOrUpdate(thEmployee);
//	}
//
//	@Override
//	public void deleteById(int theId) {
//
//		//get the current hibernate session
//		Session curretnSession = entityManager.unwrap(Session.class);
//		//delete object with primary key
//		Query theQuery = curretnSession.createQuery("delete from Employee where id=:employeeId");
//		theQuery.setParameter("employeeId", theId);
//		theQuery.executeUpdate();
//	}
//
//}
