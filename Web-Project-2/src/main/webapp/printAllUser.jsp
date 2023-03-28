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
						<c:if test="${userLista.idUser != usr.idUser}">
							
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