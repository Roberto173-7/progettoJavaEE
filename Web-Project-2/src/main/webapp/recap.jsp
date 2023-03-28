<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:choose>
		<c:when test="${usr == null}">
			
			Errore nell accesso!
			
		    <br></br>
			
			<form action="home.jsp">
				<input type="submit" value="Home"><br />
			</form>
		
		</c:when>
		<c:when test="${usr.idUser == null}">
			
			Email già collegata ad un altro account!
			
		    <br></br>
			
			<form action="logout.jsp">
				<input type="submit" value="Home"><br />
			</form>
		
		</c:when>
		<c:when test="${usr.idUser != null && usr.ruolo.idRuolo == 1}">
			
			Benvenuto  ${usr.ruolo.descrizione} ${usr.nome} ${usr.cognome}
			
			<br></br>
		
			<form action="manage.jsp">
				<input type="submit" value="Home selezione funzioni user" ><br/>
			</form>
		
		</c:when>
		<c:when test="${usr.idUser != null && usr.ruolo.idRuolo == 2}">
			
			Benvenuto  ${usr.ruolo.descrizione} ${usr.nome} ${usr.cognome}
			
			<br></br>
		
			<form action="manageAdmin.jsp">
				<input type="submit" value="Home selezione funzioni admin" ><br/>
			</form>
		
		</c:when>
		
		<c:otherwise>
			Credenziali non valide per l'accesso!
			
		    <br></br>
			
			<form action="home.jsp">
				<input type="submit" value="Home"><br />
			</form>
		</c:otherwise>
	</c:choose>
<br>
</div>
</body>
</html>