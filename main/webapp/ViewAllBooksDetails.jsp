<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, test.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View All Books detail</title>
<style>
table{
    width: 100%;
    border-collapse: collapse;
}
th, td{
    border: 1px solid black;
    padding: 8px;
    text-align: left;
}
th{
    background-color: #f2f2f2;
}
</style>
</head>
<body bgcolor =silver text =black>
<center>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("alist");
out.print("This Page belongs to :"+cb.getFname()+"<br>");
if(al.size()==0){
	out.print("Books are not available....<br>");
}else{
	out.print("<table>");
	out.print("<tr><th>Book_Code</th><th>Book_Name</th><th>Author_Name</th><th>Price</th><th>Quantity</th><th>Buy</th></tr>");
	
	Iterator<BookBean> it = al.iterator();
	while(it.hasNext()){
		BookBean bb = it.next();
		out.print("<tr>");
		out.print("<td>"+bb.getCode()+"</td>");
		out.print("<td>"+bb.getName()+"</td>");
		out.print("<td>"+bb.getAuthor()+"</td>");
		out.print("<td>"+bb.getPrice()+"</td>");
		out.print("<td>"+bb.getQty()+"</td>");
		out.print("<td><a href='buy?bcode="+bb.getCode()+"'>Buy</a></td>");
		out.print("</tr>");
	}
	out.print("</table>");
}
%>
<a href="logout">Logout</a>
</center>
</body>
</html>