<%@page
	import="com.valtech.training.newspringboot.model.DepartmentModels"%>
<%@page import="com.valtech.training.newspringboot.model.EmployeeModels"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of All Employees</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	margin: 20px;
	padding: 20px;
	background-color: #f4f4f4;
	text-align: center;
}

h1 {
	color: #333;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #ddd;
	align: center;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:hover {
	background-color: #f5f5f5;
}

form {
	display: inline;
}

input[type="submit"] {
	background-color: #008CBA;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	align: center;
}

input[type="submit"]:hover {
	background-color: #000000;
	align: center;
}
</style>
</head>
<body>
	<h1>List of Employees</h1>
	<%
	List<EmployeeModels> employees = (List<EmployeeModels>) request.getAttribute("employees");
	%>
	<%
	/* List<DepartmentModels> departments = (List<DepartmentModels>) request.getAttribute("departments"); */
	DepartmentModels departmentModels = (DepartmentModels) request.getAttribute("departments");
	request.setAttribute("current", departmentModels.getId());
	%>
	<table>
		<tr>
			<th>Department_ID</th>
			<th>Department_Name</th>
			<th>Department_Location</th>
		</tr>
		<%-- <%
		for (DepartmentModels department : departments) {
			request.setAttribute("department", department);
		%> --%>
		<%
		request.setAttribute("department", departmentModels);
		%>
		<tr>
			<td>${department.id}</td>
			<td>${department.dname}</td>
			<td>${department.dlocation}</td>
		</tr>

		<%-- <%
		}
		%> --%>
		<tr>
			<td colspan="2" align="center">
				<form action="list" method="post">
					<input type="submit" name="submit" value="First" /> <input
						type="submit" name="submit" value="Previous" /> <input
						type="submit" name="submit" value="Next" /> <input type="submit"
						name="submit" value="Last" />
				</form>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>Employee_ID</th>
			<th>Employee_Name</th>
			<th>Age</th>
			<th>Experience</th>
			<th>Seniority</th>
			<th>Salary</th>
			<th>Department_ID</th>
			<th>Actions</th>
		</tr>
		<%
		for (EmployeeModels employee : employees) {
			request.setAttribute("employee", employee);
		%>
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.age}</td>
			<td>${employee.experience}</td>
			<td>${employee.seniority}</td>
			<td>${employee.salary}</td>
			<td>${employee.department.id}</td>
			<td><a href="delete?id=${employee.id}">Delete</a> <a
				href="edit?id=${employee.id}">Edit</a></td>
		</tr>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="5" align="center">
					<form method="get" action="new">
						<input type="submit" name="submit" value="Add New Employee" />
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>