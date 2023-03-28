<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento</title>
<link rel="stylesheet" href="styles2.css">

</head>
<body >
<div>
<br>
	<form action="MainServlet" method="post">
		<p>Email:</p>
		<input type="text" name="email" placeholder="email">
		<p>Password:</p>
		<input type="text" class="key" name="password" > <br></br> 
		<input type="hidden" name="toLogin" value="toLogin"> <br></br> 
		<input class="input2" type="submit" value="Accedi">
	</form>
		<br></br> <br></br> 
		<form action="home.jsp">
				<input type="submit" value="Torna pagina iniziale" ><br/>
		</form>
	<br>
</div>
</body>
</html>