<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment</title>
</head>
<body bgcolor =silver text =black>
<center>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
Float payable = (Float)request.getAttribute("payable");
out.print("This Page belongs to : "+cb.getFname()+"<br>");
out.print("Total Payable Amount = "+payable+"<br>");
%>
<form action="Payment.jsp" method="post">
<input type ="submit" name ="Pay"><br>
</form>
<a href ="BuyBook.jsp">Back</a><br>
<a href ="view1">ViewAllBooksDetails</a><br>
<a href ="logout">Logout</a><br>
</center>
</body>
</html>