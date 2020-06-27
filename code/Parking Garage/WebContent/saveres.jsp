<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dataStructures.Customer" %>
<%@ page import="dataStructures.Car" %>
<%@ page import="dataStructures.Reservation" %>
<%@ page import="database.Database" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.Integer.*" %>
<%@ page import="java.util.ArrayList.*" %>
<%@ page import="java.util.Calendar.*" %>
<%@ page import="java.util.*" %>
<%
Database.connectToDatabase();
String cid = request.getParameter("customerID");
int custID = Integer.parseInt(cid);
String lsplate = request.getParameter("lplate");
String mn = request.getParameter("month");
int month = Integer.parseInt(mn);
String d = request.getParameter("day");
int day = Integer.parseInt(d);
String starth = request.getParameter("starthour");
int sh = Integer.parseInt(starth);
String startm = request.getParameter("startminute");
int sm = Integer.parseInt(startm);
String endh = request.getParameter("endhour");
int eh = Integer.parseInt(endh);
String endm = request.getParameter("endminute");
int em = Integer.parseInt(endm);
GregorianCalendar start = new GregorianCalendar();
start.set(2011,month,day,sh,sm);
GregorianCalendar end = new GregorianCalendar();
end.set(2011,month,day,eh,em);
Customer cust= Customer.ID_to_Customer(custID);
ArrayList<Car> cars = cust.getCars();
int carnum = 0;
int ind =0;
String carplate = new String();
int carID=0;
while(ind == 0){
	carplate = cars.get(carnum).getLicensePlate();
	carID = cars.get(carnum).getCarID();
	carnum++;
	if(carplate.equals(lsplate))
	ind =1;
}
Reservation newres = new Reservation(custID,1,carID,start,end);
String smn = new String();
if(sm == 0)
	smn = "00";
else
	smn = Integer.toString(sm);
String emn = new String();
if(em == 0)
	emn = "00";
else
	emn = Integer.toString(em);
		
request.setAttribute("shour",sh);
request.setAttribute("smin",smn);
request.setAttribute("ehour",eh);
request.setAttribute("emin",emn);
request.setAttribute("mon",month);
request.setAttribute("date",day);
request.setAttribute("cstID",custID);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>
<body>
<h1 align=center>Thank You for Your Reservation</h1>
<h3>Your Reservation is from <%=request.getAttribute("shour") %> : <%=request.getAttribute("smin") %> to <%=request.getAttribute("ehour") %> : <%=request.getAttribute("emin") %> on <%=request.getAttribute("mon") %> - <%=request.getAttribute("date") %> - 2011 </h3>
<a href="index.jsp">Go Back to Homepage</a><br />
<a href="viewuser.jsp?customerID=<%=request.getAttribute("cstID") %>">Manage Account</a>
</body>
</html>