<%@page import="com.valtech.training.newspringboot.model.EmployeeModels"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Employee</title>
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
        }
 
        td {
            padding: 10px;
        }
 
        label {
            display: block;
            margin-bottom: 5px;
            color: #495057;
        }
 
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            box-sizing: border-box;
        }
 
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
 
        input[type="submit"]:hover {
            background-color: #218838;
        }
 
        .cancel-btn {
            background-color: #dc3545;
        }
 
        .cancel-btn:hover {
            background-color: #c82333;
        }
    </style>
<body>
<form method="post" action="save">
	<table>
		<tr>
			<td>Employee_ID</td>
			<td><input type="text" disabled="disabled" name="id"/></td>
		</tr>
		<tr>
			<td>Employee_Name</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age"/></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><input type="text" name="experience"/></td>
		</tr>
		<tr>
			<td>Seniority</td>
			<td><input type="text" name="seniority"/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary"/></td>
		</tr>
		<tr>
			<td>Department_ID</td>
			<td><input type="text" name="department"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="submit" value="Create"/>
				<input type="submit" name ="cancel" value="Cancel"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>