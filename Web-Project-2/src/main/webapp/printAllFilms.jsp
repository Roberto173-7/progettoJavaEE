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
		<c:when test="${listaFilm != null}">
			
			${usr.nome} ${usr.cognome}, ecco a te la lista di film
			
			<br></br>
			
				Lista Film:  
				<br><br/>
					<c:forEach items="${listaFilm}" var="filmLista">
						<c:out value="Titolo: " />
					 	<c:out value="${filmLista.titolo}" />
					 	<c:out value="-- Regista: " />
					 	<c:out value="${filmLista.regista.nome}" />
					 	<c:out value="${filmLista.regista.cognome}" />
					 	<c:out value="-- Categorie: " />
					 	<c:forEach items="${filmLista.listaCategorie}" var="categoriaFilm">
							<c:out value="${categoriaFilm.nome}" />
						</c:forEach>
					 	<br><br/>
					</c:forEach>
		</c:when>
		
	</c:choose>
	<c:choose>
	<c:when test="${usr.ruolo.idRuolo == 2}">
	<form action="manageAdmin.jsp">
			<input type="submit" value="Torna alle funzioni" ><br/>
	</form>
	</c:when>
	<c:otherwise>
	<form action="manage.jsp">
			<input type="submit" value="Torna alle funzioni" ><br/>
	</form>
	</c:otherwise>
	</c:choose>
	<br>
</div>
</body>
</html>