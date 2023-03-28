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
<body>
<div>
<br>
	<c:choose>
		<c:when test="${listaCategorie != null}">
			
			${usr.nome} ${usr.cognome}, ecco a te la lista delle categorie
			
			<br></br>
			
				Lista categorie:  
				<br>
			<br />
			<c:forEach items="${listaCategorie}" var="categoriaLista">

				<form id="buttonCategorie" action="MainServlet" method="get">
					<input type="hidden" name="toGetFilmByCategory" value="${categoriaLista.idCategoria}"> 
					<input type="submit" value="${categoriaLista.nome}">
				</form>

			</c:forEach>
		</c:when>

	</c:choose>
	
	<br><br/>

	<form action="manage.jsp">
		<input type="submit" value="Torna alle funzioni"><br />
	</form>
	<br>
</div>
</body>
</html>