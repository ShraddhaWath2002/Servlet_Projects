<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="test.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Books</title>
</head>
<body bgcolor =silver text =black>
<center>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
BookBean bb = (BookBean)request.getAttribute("bbean");
out.println("This Page belongs to :"+ab.getFname()+"<br>");
%>
<form action="update" method ="post">
<input type ="hidden" name ="bcode" value=<%=bb.getCode() %>><br>
Price :<input type ="text" name ="price" value=<%=bb.getPrice() %>><br>
Quantity :<input type ="text" name ="qty" value=<%=bb.getQty() %>><br>
<input type ="submit" name ="UpdateBookDetails">
</form>
</center>
</body>
</html>