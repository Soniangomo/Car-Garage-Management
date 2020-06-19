<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.lang.Integer.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "dataStructures.Customer" %>
<%@ page import = "dataStructures.Car" %>
<%@ page import = "database.Database" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
Database.connectToDatabase();
String cname = request.getParameter( "name" );
String lsplate = request.getParameter( "lplate" );
String hc = request.getParameter( "handicapped" );
int hcp = 0;
if(hc == "")
	hcp = 0;
else
	hcp = 1;
String fpref = request.getParameter( "floorpref");
int fprf = 0;
if( fpref == "")
	fprf = -1;
else
	fprf = Integer.parseInt(fpref);
String spref = request.getParameter("spotpref");
int spotpr;
if( spref == "" )
	spotpr = -1;
else
	spotpr = Integer.parseInt(spref);
Customer newcust = new Customer(cname, fprf, hcp, spotpr );
int custID;
custID = newcust.getCustomerID();
Car newcar = new Car(lsplate, custID);
request.setAttribute("custID", custID);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1 align = "center"> Thank you for registering with Park-a-lot</h1>
<h3> Your new User ID is <%=request.getAttribute("custID") %> </h3>
<a href = "makeres.jsp?customerID=<%=request.getAttribute("custID") %>">Make Reservation</a><br />
<a href = "viewuser.jsp?customerID=<%=request.getAttribute("custID") %>"> Manage Account </a><br />
<a href = "addcar.jsp?customerID=<%=request.getAttribute("custID") %>">Add another Car to Your Account</a> <br />
<a href = "index.jsp"> Go Back to the Homepage </a>
</body>
</html>