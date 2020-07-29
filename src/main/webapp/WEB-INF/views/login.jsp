<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login page</title>
</head>
<body>
    
    <!--Centering the form in the webpage-->
	<center>
		<h1>Welcome</h1>
	
		<!-- The post request raised after the login button click is handled by the login.do servlet -->
		<form action="/dbtoser/login.do" method="POST" >
			Name : <br><input name="name" type="text" required /> <br><br>
			Password : <br> <input name="password" type="password" required /> <br><br>
			<center><input type="submit" value="Login"/></center>
		</form>
		
	</center>
	
</body>
</html>