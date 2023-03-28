<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles2.css">

</head>
<body >
<div>
<form action="MainServlet" method="post">
	
		<br></br>
		Titolo: <input type="text" name="titoloFilm">
		<br></br>
		Regista:
		<select name="registaFilm">
					
			<option value=" "></option>
		
			<c:forEach items="${listaRegista}" var="registaLista">
				<option value="${registaLista.idRegista}">"${registaLista.nome} ${registaLista.cognome}"</option>
			</c:forEach>
      	</select>
		<br></br>
		<span>
		Categorie:
		<br></br>
		<c:forEach items="${listaCategoria}" var="categoriaLista"  varStatus="count">
				<input id="checkboxes" type="checkbox" name="categorieSelezionate"  value="${categoriaLista.idCategoria}">${categoriaLista.nome}
				<c:if test="${count.index%5==0 && count.index!=0}"> 	<br> 	</c:if>
		</c:forEach>
      	<br></br>
      	</span>
      	
		<input type="hidden" name="toInsertFilm" value="toInsertFilm" >
		
		<input type="submit" value="Conferma Inserimento film">
	</form>
	<br>
	<form action="manageAdmin.jsp">
			<input type="submit" value="Torna alle funzioni" ><br/>
	</form>
	<br>
</div>
</body>
</html>