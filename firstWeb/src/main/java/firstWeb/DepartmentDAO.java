package firstWeb;

import java.sql.SQLException;
import java.util.List;
 
public interface DepartmentDAO {
 
	void createDepartment(Department dept) throws SQLException;
 
	List<Department> getDepartments() throws SQLException;
 
	void updateDepartment(Department dept) throws SQLException;
 
	void deleteDepartment(int id) throws SQLException;
 
	Department getDepartment(int id) throws SQLException;
	
	int nextid(int id) throws SQLException;

	int lastid() throws SQLException;

	int previousid(int id) throws SQLException;

	int firstid() throws SQLException;

}