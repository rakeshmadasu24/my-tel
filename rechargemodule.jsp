<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge</title>
</head>
<body style="background-color:tan;">
<h2 style="text-align:center;">Mytel</h2>
<h3 style="margin-left:10%;">Welcome User
<a href="login.html" style="margin-left:75%;">Logout</a>
</h3><br><br><br>

<h3 style="text-align:center;"> Mobile Recharge</h3>
<form method="post" action="packages">
<h2 style="text-align:center;" >Mobile number :<input type="text" name="contact" required></h2> 
<h3 style="text-align:center;">
<label for="packages">Select an option</label>
<select id="packages" name="package">
<option selected="selected" name="hidden">Packages</option>

<option value="package1" >Package1</option>
<option value="package2" >Package2</option>
<option value="package3" >Package3</option>
</select><br><br>
<input type=submit value=Proceed>
</h3>
</form>
<h4 style="text-align:center;"><a href="./mytelhome.jsp">Home</a></h4>
</body>
</html>