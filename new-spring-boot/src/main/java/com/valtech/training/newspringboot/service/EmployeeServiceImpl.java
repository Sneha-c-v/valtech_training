package com.valtech.training.newspringboot.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.newspringboot.entity.Department;
import com.valtech.training.newspringboot.entity.Employee;
import com.valtech.training.newspringboot.repositeries.DepartmentRepo;
import com.valtech.training.newspringboot.repositeries.EmployeeRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;

	@PostConstruct
	public void populateEmployee() {
		
		Employee emp = new Employee("Sneha",21,1,1,45000);
		Employee emp1 = new Employee("Bhavana",20,1,1,45000);
		Employee emp2 = new Employee("Kruthik",22,1,1,45000);
		Employee emp3 = new Employee("Gagan",20,1,1,45000);
		Employee emp4 = new Employee("Chandu",22,1,1,45000);
		
		Department dep = new Department("Market","Bangalore");
		Department dep1 = new Department("Manager","delhi");
		Department dep2 = new Department("Sales","Channai");
		Department dep3 = new Department("Finance","Bangalore");
		Department dep4 = new Department("Consaltancy","Pune");
		
		departmentRepo.save(dep);
		departmentRepo.save(dep1);
		departmentRepo.save(dep2);
		departmentRepo.save(dep3);
		departmentRepo.save(dep4);
		
		emp.setDepartment(dep);
		employeeRepo.save(emp);
		
		emp1.setDepartment(dep1);
		employeeRepo.save(emp1);
		
		emp2.setDepartment(dep2);
		employeeRepo.save(emp2);
		
		emp3.setDepartment(dep3);
		employeeRepo.save(emp3);
		
		emp4.setDepartment(dep4);
		employeeRepo.save(emp4);
	
	}
	
	@Override
	public Employee createEmployee(Employee emp) {
		
		System.out.println(employeeRepo.getClass().getName());
		return employeeRepo.save(emp);
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {

		return employeeRepo.save(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		
		employeeRepo.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		
		return employeeRepo.getReferenceById(id);
	}
	
	@Override
	public Department createDepartment(Department dep) {
		
		System.out.println(departmentRepo.getClass().getName());
		return departmentRepo.save(dep);
	}
	
	@Override
	public Department updateDepartment(Department dep) {

		return departmentRepo.save(dep);
	}

	@Override
	public List<Department> getAllDepartments() {

		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartment(int id) {
		
		return departmentRepo.findById(id).orElse(null);
	}
	
	@Override
	public int getFirstId() {
		
		return departmentRepo.findMinId();
	}

	@Override
	public int getLastId() {

		return departmentRepo.findMaxId();
	}

	@Override
	public int getPreviousId(int id) {

		int id1 = departmentRepo.findPreviousId(id);
		return id1 == 0 ? getLastId() : id1;
	}

	@Override
	public int getNextId(int id) {

		int id1 = departmentRepo.findNextId(id);
		return id1 == 0 ? getFirstId() : id1;
	}
	
	@Override
	public List<Employee> getAllEmployeesByDepartmentId(int did) {

		return employeeRepo.findEmployeeByDepartmentId(did);
	}
	
}