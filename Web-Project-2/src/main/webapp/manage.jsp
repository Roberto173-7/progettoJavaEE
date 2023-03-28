<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Management</title>
<link rel="stylesheet" href="styles2.css">

</head>
<body >
<div>
<br>
	<form action="update.jsp">
			<input type="submit" value="Aggiorna dati" ><br/>
	</form>
	
	<br></br>
	<form action="delete.jsp">
			<input type="submit" value="Elimina account" ><br/>
	</form>
	<br></br>
	<form action="MainServlet" method="get">
			<input type="hidden" name="toGetAll" value="toGetAll">
			<input type="submit" value="Visualizza tutti i film" ><br/>
	</form>
	
	<br></br>
	<form action="MainServlet" method="get">
			<input type="hidden" name="toGetAllCategories" value="toGetAllCategories">
			<input type="submit" value="Accedi menu selezione categoria" ><br/>
	</form>
	<br></br>
	<form action="logout.jsp">
			<input type="submit" value="logout" ><br/>
	</form>
	<br>
</div>
</body>
</html>