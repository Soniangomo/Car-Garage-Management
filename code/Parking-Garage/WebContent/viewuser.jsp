<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dataStructures.Customer" %>
<%@ page import="dataStructures.Car" %>
<%@ page import="dataStructures.Reservation" %>
<%@ page import="database.Database" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.Integer.*" %>
<%@ page import="java.util.ArrayList.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Database.connectToDatabase();
String cid = request.getParameter("customerID");
int cstid = Integer.parseInt(cid);
Customer cust = Customer.ID_to_Customer(cstid);
request.setAttribute("custID",cstid);
ArrayList<Car> cars = cust.getCars();
int count = cars.size();
ArrayList<Reservation> upres = cust.getUpcomingReservations();
int uprescount = upres.size();

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Account</title>
</head>
<body>
<a href="makeres.jsp?customerID=<%=request.getAttribute("custID") %>">Make New Reservation</a> <br />
<a href="addcar.jsp?customerID=<%=request.getAttribute("custID") %>">Add another Car to your Account</a>
<h3>Cars Registered to This Account</h3>
<%System.out.println(count); %>
<table bgcolor="#F6E3CE" border="1" width="10%">
<%
String lplate = new String();
for(int i=0;i<count;i++){
	%><tr align=center><td><%
	lplate = cars.get(i).getLicensePlate();
	request.setAttribute("lsp",lplate);%>
	  
	<%=request.getAttribute("lsp") %></td>
	</tr>
	<%} %>
	</table>
	</body>
</html>