package firstWeb;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	void deleteEmployee(int id) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int id) throws SQLException;

//	public long count() throws SQLException;

//	int nextid(int id) throws SQLException;

//	int lastid() throws SQLException;

//	int previousid(int id) throws SQLException;

//	int firstid() throws SQLException;

	char[] getEmployeeAgeBetween(int i, int j);
	
	List<Employee> getEmployeeByDeptName(String deptName) throws SQLException;

}
