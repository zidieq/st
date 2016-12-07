<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="/st/index_load.action" method="post">
		<div>
			UserName:<input type="text" name="user.username" /><br /> PassWord:<input
				type="password" name="user.password" /><br /> Age:<input
				type="text" name="user.age" /><br /> Birthday:<input type="text"
				name="user.birthday" /><br /> <input type="submit" value="submit" />
		</div>
	</form>
</body>
</html>