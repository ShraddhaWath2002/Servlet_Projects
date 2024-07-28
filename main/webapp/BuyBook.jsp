<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buy Book</title>
</head>
<body bgcolor =silver text =black>
<center>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
BookBean bb = (BookBean)session.getAttribute("bbean");
out.println("This Page belongs to "+cb.getFname()+"<br>");
%>
<form action="pay" method ="post">
BookCode :<input type ="text" name ="code" value=<%=bb.getCode() %>><br>
BookName :<input type ="text" name ="name" value=<%=bb.getName() %>><br>
Author :<input type ="text" name ="author" value=<%=bb.getAuthor() %>><br>
Price :<input type ="text" name ="price" value=<%=bb.getPrice() %>><br>
Quantity :<input type ="text" name ="qty" value=<%=bb.getQty() %>><br>
Required Quantity :<input type ="text" name ="req" ><br>
<input type ="submit" name ="BuyBooks">
</form>
</center>
</body>
</html>