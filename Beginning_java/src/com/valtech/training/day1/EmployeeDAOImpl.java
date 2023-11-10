package com.valtech.training.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		int rowsUpdated=ps.executeUpdate();
		
		System.out.println(rowsUpdated);
		conn.close();
		
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("UPDATE EMPLOYEE SET NAME=?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=?,DEPARTMENT=? WHERE ID=?");
        populatePreparedStatementfromEmployee(emp, ps);
        ps.setInt(6,emp.getId());
        int rowsUpdated=ps.executeUpdate();
        System.out.println("Rows updated "+rowsUpdated);
        conn.close();
}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY) VALUES (?,?,?,?,?)");
		populatePreparedStatementfromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		conn.close();

	}

	private void populatePreparedStatementfromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {

		}
		conn.close();
		return emps;

	}

	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Employee e = mapRowtoEmployee(rs);
			conn.close();
			return e;

		} else {
			System.out.println("no row with id=" + id + "found...");
			return null;
		}

	}

	

	private Employee mapRowtoEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		return e;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}

	public static void main(String[] args) throws SQLException {

				EmployeeDAO dao = new EmployeeDAOImpl();
			    System.out.println(dao.getEmployee(1));
		        System.out.println(dao.getEmployee(2));
			    System.out.println(dao.getAllEmployees());
			    Employee e=dao.getEmployee(1);
				e.setSeniority(5);
//				dao.updateEmployee(e);
				System.out.println(dao.getAllEmployees());
		        dao.createEmployee(new Employee("XYZ", 35, 3, 4, 39000,123));
		        dao.createEmployee(new Employee("Afg", 35, 8, 7, 39067,234));
//				dao.deleteEmployee(1);
	}

	@Override
	public long count() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT COUNT(ID) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		rs.next();
		long count=rs.getLong(1);
		conn.close();
		
		// TODO Auto-generated method stub
		return count;
	}

}
