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
<form action="MainServlet" method="post">
	
		<br></br>
		Nome: <input type="text" name="nomeRegista">
		<br></br>
		Cognome: <input type="text" name="cognomeRegista">
		<br></br>
		<input type="hidden" name="toInsertRegista" value="toInsertRegista" >
		
		<input type="submit" value="Conferma Inserimento regista">
	</form>
	<br>
	<form action="manageAdmin.jsp">
			<input type="submit" value="Torna alle funzioni" ><br/>
	</form>
	<br>
</div>
</body>
</html>