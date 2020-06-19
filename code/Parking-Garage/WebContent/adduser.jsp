<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1 align = "center"> Registration </h1>
<h3>Name</h3>
<form method=POST ACTION= "savenewacc.jsp">
<input type= "text" name = "name">
<h3>License Plate Number</h3>
<form><input type=text name=lplate>
<h3> Preferences</h3>
<form> <input type =checkbox name =handicapped value = "1">Handicapped <br />
<h4> Floor # </h4>
<form> <input type = text name =floorpref> 
<h4> Spot # </h4>
<form> <input type =text name = spotpref> <br />
<P><INPUT TYPE=SUBMIT></form>
</body>
</html>