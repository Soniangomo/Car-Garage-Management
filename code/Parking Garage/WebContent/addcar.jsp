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
request.setAttribute("cstID",custID);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Please Enter the License Plate # of the New Car</h3>
<form method=post action="savenewcar.jsp?customerID=<%=request.getAttribute("cstID") %>"><input type=text name="lplate">
<p><input type=submit></form>
</body>
</html>