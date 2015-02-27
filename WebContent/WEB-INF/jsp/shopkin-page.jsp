<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Shopkin Entry</title>
<style type="text/css">
body {
}
</style>
</head>
<body>
	<br>
	<div align=center>
		<h2>Shopkins Everywhere!</h2>
	
		<div>
			<form commandname="shopkin-entity" action="process-shopkin.html" method="post">
				<table>
					<tr><td colspan=2>Enter a new Shopkin:</td></tr>	
					<tr><td>ID:</td><td><input type="text" name="id" /></td></tr>
					<tr><td>Name:</td><td><input type="text" name="name" /></td></tr>
					<tr><td colspan=2><input type="submit" name="submit" value="Submit" /></td></tr>
				</table>
			</form>
		</div>
		
	</div>
</body>
</html>