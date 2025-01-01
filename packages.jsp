<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="b" class="project.packagesjsp">
            <jsp:setProperty name="b" property="contact" param="contact"/>
            <jsp:setProperty name="b" property="package1" param="package"/>
            <h3 style="text-align: center;"><br><br>
                <% b.insert(); %>
            </h3>
        </jsp:useBean>
        
</body>
</html>