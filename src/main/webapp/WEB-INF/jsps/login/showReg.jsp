<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body bgcolor="darkvoilet">
	<fieldset>
		<legend>
			<h2>
				<i>Create new Account</i>
			</h2>
		</legend>
		<form action="saveReg" method="post">
		
			First Name:<input type="text" name="firstName" /><br>
			<br> Last Name:<input type="text" name="LastName" /><br>
			<br> Email:<input type="text" name="email" /><br>
			<br> Password:<input type="text" name="password" /><br>
			<br> <input style="" type="submit" value="Submit">

		</form>
	</fieldset>
</body>
</html>