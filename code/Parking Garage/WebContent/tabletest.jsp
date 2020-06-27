<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <FORM NAME="form1" ACTION="tabletest.jsp" 
METHOD="get">           
            <table bgcolor="#D8D8D8">
                <p><font color="#F8E0F7">Enter number for 
which you want to create <br>table
                and limit of table here.</font></p> 
                <tr>
                    <td> Enter number </td>
                    <td><input type="text" name="num"></td>
                </tr>
                <tr>
                    <td> Enter limit </td>
                    <td><input type="text" name="limit"></td>
                </tr>
                <tr align="center"><td></td>
                <td><INPUT TYPE="submit" VALUE="show table"></td>
            </table><br>
            <table bgcolor="#F6E3CE" border="1" width="23%">

            <%
	      /* here if statement will check that text 
boxes are empty or value in text boxes 
		  are null */ 
	     if (request.getParameter("num") 
!= null && request.getParameter("limit") != null){  
             if (request.getParameter("num") 
!= "" && request.getParameter("limit") != "") {

	          // use for loop
                  for (int i = 0; i < 
Long.parseLong(request.getParameter("limit")); i++) {
            %>
            <tr align="center">
                <td><%= request.getParameter("num")%>
 * <%= (i + 1)%></td>
                <td><%= (
Long.parseLong(request.getParameter("num")) * (i + 1))%></td>

            </tr>
            <% }
                }
            }%>
        </FORM>
</body>
</html>