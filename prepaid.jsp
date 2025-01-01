<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>postpaid</title>
</head>
<body style="background-color:aqua;">
<h2 style="text-align:center;">Mytel</h2>
<h3 style="margin-left:10%;">Welcome User
<a href="login.html" style="margin-left:75%;">Logout</a>
</h3><br><br><br>
<h3 style="text-align:center;">Conversion :<br><br>
<form action="./prepaidservlet" method=post>
<label>Mobile Number :</label>
<input type=text name=contact required><br><br>
<input type="submit" value="Click to Convert" > </form>
</h3>
</body>
</html>