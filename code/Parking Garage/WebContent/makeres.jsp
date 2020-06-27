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
Database.connectToDatabase();
String cid = request.getParameter("customerID");
int custID = Integer.parseInt(cid);
request.setAttribute("cstID",custID);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservations</title>
</head>
<body>
<h1 align=center>Make Reservation</h1>
<h3>Please Input the License Plate # of the Car that Will be Parking</h3>
<h4>Please note that you can only make a reservation with a car that has already been registered.</h4>
<h4>To register a new car <a href="addcar.jsp?customerID=<%=request.getAttribute("cstID") %>">Click Here</a></h4> 
<form method=post action="saveres.jsp?customerID=<%=request.getAttribute("cstID") %>">
<input type=text name="lplate">
<h3>Please Input the Date</h3>
<input type=text name="month"><input type=text name="day">
<h3>Please Input the Time that the Reservation will Begin</h3>
<input type=text name="starthour">:<input type=text name="startminute">
<h3>Please Input the Time that the Reservation will End</h3>
<input type=text name="endhour">:<input type=text name="endminute">
<p><input type=submit></p></form>


</body>
</html>