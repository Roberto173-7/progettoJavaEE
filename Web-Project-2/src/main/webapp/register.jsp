<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="styles2.css">
<meta charset="ISO-8859-1">
<title>Registrazione</title>

</head>
<body >
<div>
<br>
	<form action="MainServlet" method="post">
	
		Nome: <input type="text" name="nome">
		<br></br>
		Cognome: <input type="text" name="cognome">
		<br></br>
		Email: <input type="text" name="email">
		<br></br>
		Password: <input type="text" name="password">
		<br></br>
		
		<input type="hidden" name="toInsert" value="toInsert">
		<input type="submit" value="Conferma registrazione">
	</form>
	<br></br> <br></br> 
		<form action="home.jsp">
				<input type="submit" value="Torna pagina iniziale" ><br/>
		</form>
	<br>
</div>
</body>
</html>