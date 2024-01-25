<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<fieldset>
		<legend>
			<h2>
				<i>Login Here</i>
			</h2>
		</legend>
		<form action="verifyLogin" method="post">
		
			 Email:<input type="text" name="email" /><br>
			<br> Password:<input type="text" name="password" /><br>
			<br> <input style="" type="submit" value="Login">

		</form>
		${error}
	</fieldset>
</body>
</html>