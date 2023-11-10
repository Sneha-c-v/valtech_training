package com.valtech.training.day1;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	void deleteEmployee(int id) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int id) throws SQLException;
	 public long count() throws SQLException;
		
	}



	
