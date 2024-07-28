<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body bgcolor =silver text =black>
<center>
<%
session.invalidate();
out.print("Loggedout Successfully....<br>");
%>
<jsp:include page="home.html"></jsp:include>
</center>
</body>
</html>