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
		<c:when test="${listaUser != null}">
			
			${usr.nome} ${usr.cognome}, ecco a te la lista di utenti
			
			<br></br>
			
				Lista utenti:  
				<br><br/>
					<c:forEach items="${listaUser}" var="userLista">
						<c:if test="${userLista.ruolo.idRuolo != 2}">
							
						<c:out value="Id utente: " />
					 	<c:out value="${userLista.idUser}" />
					 	<c:out value=", Nome: " />
					 	<c:out value="${userLista.nome}" />
					 	<c:out value=", Cognome: " />
					 	<c:out value="${userLista.cognome}" />
					 	<c:out value=", Email: " />
					 	<c:out value="${userLista.email}" />
					 	<c:out value=", Ruolo: " />
					 	<c:out value="${userLista.ruolo.descrizione}" />
					 	
					 	<form action="MainServlet" method="post">
								<input type="hidden" name="idToAdmin" value="${userLista.idUser}">
								<input type="hidden" name="nomeToAdmin" value="${userLista.nome}">
								<input type="hidden" name="cognomeToAdmin" value="${userLista.cognome}">
								<input type="hidden" name="emailToAdmin" value="${userLista.email}">
								<input type="hidden" name="passwordToAdmin" value="${userLista.password}">
								<input type="submit" value="Rendi Admin" ><br/>
						</form>
					 	
					 	<br><br/>
							
							
						</c:if>
						
					 </c:forEach>
					
		</c:when>
		
	</c:choose>

	<form action="manageAdmin.jsp">
			<input type="submit" value="Torna alle funzioni" ><br/>
	</form>
	<br>

</div>
</body>
</html>