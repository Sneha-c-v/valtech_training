<%@page import="com.valtech.training.newspringboot.model.EmployeeModels"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f8f9fa;
        }
 
        form {
            width: 50%;
            margin: auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
 
        h1 {
            color: #007bff;
            text-align: center;
        }
 
        table {
            width: 100%;
            margin-bottom: 15px;
            border-collapse: collapse;
        }
 
        td {
            padding: 10px;
            border: 1px solid #dee2e6;
        }
 
        label {
            display: block;
            margin-bottom: 5px;
            color: #495057;
        }
 
        input[type="text"] {
            width: calc(100% - 16px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            box-sizing: border-box;
        }
 
        input[type="submit"], .cancel-btn {
            background-color: #007bff;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
 
        input[type="submit"]:hover, .cancel-btn:hover {
            background-color: #0056b3;
        }
 
        .cancel-btn {
            background-color: #dc3545;
            margin-left: 10px;
        }
    </style>
<body>
<%EmployeeModels employees = (EmployeeModels) request.getAttribute("employees"); %>
<form method="post" action="save?id=<%= employees.getId()%>">
	<table>
		<tr>
			<td>Employee_ID</td>
			<td><input type="text" disabled="disabled" name="id" value="<%= employees.getId()%>"/></td>
		</tr>
		<tr>
			<td>Employee_Name</td>
			<td><input type="text" name="name" value="<%= employees.getName()%>"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" value="<%= employees.getAge()%>"/></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><input type="text" name="experience" value="<%= employees.getExperience()%>"/></td>
		</tr>
		<tr>
			<td>Seniority</td>
			<td><input type="text" name="seniority" value="<%= employees.getSeniority()%>"/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary" value="<%= employees.getSalary()%>"/></td>
		</tr>
		<tr>
			<td>Department_ID</td>
			<td><input type="text" name="department" value="<%= employees.getDepartment().getId()%>"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="submit" value="Create"/>
				<input type="submit" name ="cancel" value="Cancel"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>