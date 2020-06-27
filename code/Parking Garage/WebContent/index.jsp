<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parking Garage</title>
</head>
<body>
<% java.util.Date d = new java.util.Date(); %>
<h1 = ALIGN = "CENTER">
Welcome to Park-a-Lot</h1> <br>
<h3> Please login to view account</h3>
<h4> User ID</h4>
<form method=post action="viewuser.jsp">
<input type= "text" name = "customerID">
<P><input type=submit></form>
<h6> Don't have an account? </h6>
<h6> <a href = "adduser.jsp"> Register </a> </h6>
</body>
</html>