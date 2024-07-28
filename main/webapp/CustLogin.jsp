<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="test.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Login</title>
</head>
<body bgcolor =silver text =black>
<center>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
out.println("This page belongs to : "+cb.getFname()+"<br>");
%>
<a href ="view1">ViewAllBooksDetails</a><br>
<a href ="logout">Logout</a>
</center>
</body>
</html>