
<%@page import="firstWeb.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Details</title>
</head>
<body>
	<%
	Department dept = (Department) session.getAttribute("dept");
	%>
	<table>
		<tr>
			<td>id</td>
			<td><%=dept.getDeptid()%></td>

		</tr>
		<tr>
			<td>Name</td>
			<td><%=dept.getDeptname()%></td>

		</tr>
		<tr>
			<td>Location</td>
			<td><%=dept.getDeptloc()%></td>

		</tr>
		<tr>
			<td>ListofEmp</td>
			<td><%=dept.getListofemp()%></td>

		</tr>
		
		
		<tr>
			<td colspan="2">
				<form action="empCtlr" method="post">
					<input type="submit" name="submit" value="First" /> <input
						type="submit" name="submit" value="Previous" /> <input
						type="submit" name="submit" value="Next" />
						 <input type="submit" name="submit" value="Last" />
				</form>
	</table>
</body>
</html>