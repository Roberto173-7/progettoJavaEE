<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles2.css">

</head>
<body >
	<div>
	<img src="logo.png" alt="Icona" width=200px height=200px>
	<img src="exolab-logo.png" alt="Icona" height=200px>
	<img id="logo2" src="logo2.png" alt="Icona" width=150px height=150px>
	<br>
	<c:choose>
		<c:when test="${usr == null}">

			<form action="login.jsp">
				<input type="submit" value="Accedi"><br />
			</form>

			<br></br>

			<form action="register.jsp">
				<input type="submit" value="Registati"><br />
			</form>
			
			<br>
			

		</c:when>
		<c:otherwise>

			<jsp:forward page="manage.jsp"></jsp:forward>

		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>