<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Books details</title>
</head>
<body bgcolor =silver text =black>
<center>
<%
AdminBean ab =(AdminBean)session.getAttribute("abean");
String msg =(String)request.getAttribute("msg");
out.print("This Page belongs to"+ab.getFname()+"<br>");
out.print(msg);
%>
<a href ="Book.html">AddBookDetails</a><br>
<a href ="view">ViewAllBookDetails</a><br>
<a href ="logout">Logout</a>
</center>
</body>
</html>