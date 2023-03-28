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
	<form action="MainServlet" method="get">
			<input type="hidden" name="toGetAllUser" value="toGetAllUser">
			<input type="submit" value="Visualizza utenti e altri admin" ><br/>
	</form>
	<br></br>
	<form action="MainServlet" method="get">
			<input type="hidden" name="toGetAllUserNotAdmin" value="toGetAllUserNotAdmin">
			<input type="submit" value="Rendi admin un utente" ><br/>
	</form>
	<br></br>
	<form action="MainServlet" method="get">
			<input type="hidden" name="toGetAllRegistiAndCategorie" value="toGetAllRegistiAndCategorie">
			<input type="submit" value="Inserisci un film" ><br/>
	</form>
	<br></br>
	<form action="inserisciRegista.jsp">
			<input type="submit" value="Inserisci Regista" ><br/>
	</form>
	<br></br>
	
	<form action="MainServlet" method="get">
			<input type="hidden" name="toGetAll" value="toGetAll">
			<input type="submit" value="Visualizza tutti i film" ><br/>
	</form>
	<br></br>
	<form action="logout.jsp">
			<input type="submit" value="logout" ><br/>
	</form>
	<br>
	</div>
</body>
</html>