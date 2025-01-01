 
<!DOCTYPE html>
<html>
<head>
 
<title>Registration</title>
</head>
<body style="background-color:tan;">
<center>
<h2>Registration Form</h2><br><br>
<h3>Enter your Details</h3><br>
<form action="register" method="post" >
<table border=0 width=40% >
<tr>
<td>Name :</td>
<td><input type="text" name="name" required><br><br></td>
</tr>
<tr>
<td>Mobile No. :</td>
<td><input type="text" name="contact" required><br><br></td>
</tr>
<tr>
<td>Email Id :</td>
<td><input type="email" name="email" required><br><br></td>
</tr>
<tr>
<td>Password :</td>
<td><input type="password" name="pwd" required><br><br></td>
</tr>
<tr>
<td>Address :</td>
<td><input type="text" name="address" required><br><br></td>
</tr>
<tr>
<td>Select type of User :</td>
<td><select id="usertype" name="usertype">
<option value="prepaid" >Prepaid</option>
<option value="postpaid" >Postpaid</option>
</select><br><br></td>
</tr>
</table><br><br>
<input type="submit" value="Register" > 
</form>
</center>
</body>
</html>