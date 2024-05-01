<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<div style="color: red">${error}</div>
	<form:form action="/StudentJpa/addcourse" method="post" modelAttribute="bean">
		<table>

			<tr>
				<td>Name</td>
				<td><form:input type="text" path="name"/></td>
				<td><form:errors path="name" style="color:red;"></form:errors></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><form:input type="text" path="price"/></td>
				<td><form:errors path="price" style="color:red;"></form:errors></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Add"></td>
			</tr>

		</table>
	</form:form>
</body>
</html>