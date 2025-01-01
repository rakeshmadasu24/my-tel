<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body style="background-color:tan;">
<h2 style="text-align:center;">Mytel</h2>
<h3 style="margin-left:10%;">Welcome User
<a href="login.html" style="margin-left:75%;">Logout</a>
</h3><br><br><br>
<h3 style="text-align:center;">Enter Payment Details
<center>
<form action="rechargedone.jsp" method="post" >
<table >
<tr>
<td>Enter Debit Card No. :</td>
<td><input type="text" name="cardno" required><br><br></td>
</tr>
<tr>
<td>Expiry Date :</td>
<td><input type="text" name="date" required><br><br></td>
</tr>
<tr>
<td>CVV :</td>
<td><input type="text" name="cvv" required><br><br></td>
</tr>
</table>
<input type=submit value=Confirm>
</form></center></h3>
</body>
</html>