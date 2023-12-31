package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernet.Employee;
  //all dao classes will be defined using the repository
//@service for all classes that are service classes..they will need Tx support
//@Controller for all classes when we want them to be used for presentation logic
//@Component they are general classes which have to be registered with beanfactory
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private SessionFactory sessionFactory;
	
	@Override
	public Employee saveEmployee(Employee emp){
		System.out.println("SessionFactory "+sessionFactory);
		Session ses=sessionFactory.openSession();
		 ses.persist(emp);
		 return emp;
		
	}
	@Override
	public Employee loadEmployee(int empId) {
		Session ses=sessionFactory.getCurrentSession();
		 Employee emp=(Employee)ses.load(Employee.class, empId);
		 return emp;
		
	}
	@Override
	public  Employee updateEmployee(Employee emp) {
		Session ses=sessionFactory.getCurrentSession();
		emp=(Employee)ses.merge(emp);
		 return emp;
		
	}
	@Override
	public List<Employee> getAllEmployees(){
		Session ses=sessionFactory.getCurrentSession();
		 List<Employee> emps=ses.createQuery("from Employee e").list();
		 return emps;
		
	}
	@Override
	public void deleteEmployee(Employee emp) {
		 Session ses=sessionFactory.getCurrentSession();
		 ses.delete(emp);
		 
		 }
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
