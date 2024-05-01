<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,th,td{
border :solid blue;
border-collapse:collapse;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<div style="color :'blue';">${msg}</div>
<div style="color :'red';">${error}</div>
<br>
<table>
<tr>
<th>Course id</th>
<th>Name</th>
<th>Price</th>
<th>Action</th>
</tr>
<c:forEach items="${list }" var="data">
<tr>
<td>${data.id }</td>
<td>${data.name }</td>
<td>${data.price }</td>
<td>
<a href="/BookManagement_SpringJPA/setupupdate/${data.id }">Update</a>|
<a href="/BookManagement_SpringJPA/deletebook/${data.id}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>