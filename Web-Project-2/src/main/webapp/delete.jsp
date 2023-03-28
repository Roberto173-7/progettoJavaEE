<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles2.css">
<title>Delete</title>

</head>
<body >
<div>
<br>
	<form action="MainServlet" method="post">

		Nome : ${usr.nome} <br /> Cognome : ${usr.cognome} <br /> <br> <input
			type="hidden" name="idUser" value="${usr.idUser}"> <input
			type="hidden" name="toDelete" value="toDelete"> <input
			type="submit" value="Elimina">
	</form>
	<br>
	<form action="manage.jsp">
			<input type="submit" value="Torna alle funzioni" ><br/>
	</form>
	<br>
</div>
</body>
</html>