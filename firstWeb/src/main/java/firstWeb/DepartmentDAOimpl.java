package firstWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOimpl implements DepartmentDAO {

	@Override
	public void createDepartment(Department dept) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con
				.prepareStatement("INSERT INTO DEPARTMENT (DEPTID,DEPTNAME,DEPTLOC,LISTOFEMP) VALUES(?,?,?,?)");

		populatePreparedStatment(dept, ps);

		int rowsUpdated = ps.executeUpdate();

		System.out.println("Rows update:" + rowsUpdated);

		con.close();
		// TODO Auto-generated method stub
	}

	@Override
	public List<Department> getDepartments() throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("SELECT * FROM DEPARTMENT");

		ResultSet rs = ps.executeQuery();

		List<Department> dept = new ArrayList<>();

		while (rs.next()) {

			dept.add(mapSingleRow(rs));

		}

		con.close();

		return dept;
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		PreparedStatement ps = con
				.prepareStatement("UPDATE DEPARTMENT SET DEPTNAME=?,DEPTLOC=? WHERE DEPTID=? ");

		populatePreparedStatment(dept, ps);

		ps.setInt(4, dept.getDeptid());

		int rowsUpdated = ps.executeUpdate();

		System.out.println("Rows update:" + rowsUpdated);

		con.close();
	}

	@Override
	public void deleteDepartment(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPTID=?");

		ps.setInt(1, id);

		int rowsUpdated = ps.executeUpdate();

		System.out.println("Rows update:" + rowsUpdated);

		con.close();
	}

	@Override
	public Department getDepartment(int id) throws SQLException {
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("SELECT * FROM DEPARTMENT WHERE DEPTID=?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			Department dept = mapSingleRow(rs);

			con.close();

			return dept;

		}

		else {

			System.out.println("No DeptId found " + id + " ,Couldn't fetch data");

			return null;
		}
	}

	private Department mapSingleRow(ResultSet rs) throws SQLException {

		Department dept = new Department();

		dept.setDeptid(rs.getInt(1));

		dept.setDeptname(rs.getString(2));

		dept.setDeptloc(rs.getString(3));

		dept.setListofemp(rs.getInt(4));
		

		return dept;

	}

	private void populatePreparedStatment(Department dept, PreparedStatement ps) throws SQLException {

		ps.setInt(1, dept.getDeptid());

		ps.setString(2, dept.getDeptname());

		ps.setString(3, dept.getDeptloc());

		ps.setInt(4, dept.getListofemp());

	}

	// Static methods are initialized as soon as an object instance is created

	static {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	private Connection getConnection() throws SQLException {

		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/valtech2023?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");

	}

	public static void main(String[] args) throws SQLException {

		DepartmentDAO dept = new DepartmentDAOimpl();

		System.out.println(dept.getDepartment(1));

		System.out.println("---------------------");

//		dept.createDepartment(new Department(9, "Ai", "A block", 10));

		System.out.println(dept.getDepartments());

		// Create Operation

//	System.out.println("---------------------");
//		System.out.println("Creating Department");
//

//		

//		 Update Operation

//	System.out.println("---------------------");
//
//	System.out.println("Updating Department");
//
//		Department dept1=dept.getDepartment(2);
//
//		dept1.setDname("front-end Developer");
//
//		dept.updateDepartment(dept1);

		// Delete Operation

//		System.out.println("---------------------");

//		System.out.println("Delete Operation");
// 
//		dept.deleteDepartment(1);

	}

	@Override
	public int nextid(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastid() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousid(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int firstid() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
