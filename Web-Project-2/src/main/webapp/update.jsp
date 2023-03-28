<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles2.css">

</head>
<body >
<div>
<br>
<form action="MainServlet" method="post">
	
		Nome: <input type="text" name="nome" value="${usr.nome}">
		<br></br>
		Cognome: <input type="text" name="cognome" value="${usr.cognome}">
		<input type="hidden" name="email" value="${usr.email}">
		<br></br>
		Password: <input type="text" name="password" value="${usr.password}">
		<br></br>
		<input type="hidden" name="idUser" value="${usr.idUser}" >
		<input type="hidden" name="toUpdate" value="toUpdate" >
		<input type="submit" value="Conferma aggiornamento">
	</form>
	<br>
	<form action="manage.jsp">
			<input type="submit" value="Torna alle funzioni" ><br/>
	</form>
	<br>
</div>
</body>
</html>