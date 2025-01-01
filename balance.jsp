<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
</head>
<body style="background-color:tan;">
<h2 style="text-align:center;">Mytel</h2>
<h3 style="margin-left:10%;">Welcome User
<a href="login.html" style="margin-left:75%;">Logout</a>
</h3><br><br><br>
<h3 style="text-align:center;">Know Your Balance :<br><br>
<center>
<form action="./balancedetails" method="post" >
<table >
<tr>
<td>Mobile No. :</td>
<td><input type="text" name="contact" required><br><br></td>
</tr>
<tr>

</table>
<input type=submit value=Confirm>
</form></center></h3>
<h4 style="text-align:center;"><a href="./mytelhome.jsp">Home</a></h4>
</body>
</html>