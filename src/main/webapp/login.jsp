<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
</head>
<body>

<h1 style="margin-left:33%">WELCOME TO MY LIBRARY</h1>
<div style="background-color:skyblue;height:200px">
<h3 style="margin-left:40%;margin-top:5%;padding-top:20px">ENTER LOGIN DETAILS</h3>
<form action="checkuser"method="post">
<div style="margin-left:40%">
<label>Enter username:</label><input type="text"name="username"required></div>
<br>

<div style="margin-left:40%"><label>Enter password:</label><input type="password"name="userpassword"required></div>
<br>
<div style="margin-left:50%"><input type="submit"value="submit"></div>

</form>

<p style="color:red;margin-left:45%;">${message}</p>
</div>


</body>
</html>
</body>
</html>