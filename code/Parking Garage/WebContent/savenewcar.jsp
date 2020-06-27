<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dataStructures.Customer" %>
<%@ page import="dataStructures.Car" %>
<%@ page import="dataStructures.Reservation" %>
<%@ page import="database.Database" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.Integer.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String cid = request.getParameter("customerID");
int custID = Integer.parseInt(cid);
String lsplate = request.getParameter("lplate");
Car newcar = new Car(lsplate,custID);
request.setAttribute("cstID",custID);
request.setAttribute("lsp",lsplate);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Account</title>
</head>
<body>
<h1 align=center>Car Added Successfully</h1>
<h3> <%=request.getAttribute("lsp") %> was added to your account.</h3>
<a href="viewaccount.jsp?customerID=<%=request.getAttribute("cstID") %>">Manage Account</a><br />
<a href="index.jsp">Go back to Homepage</a><br />
<a href="makeres.jsp?customerID=<%=request.getAttribute("cstID") %>">Make a Reservation</a>
</body>
</html>