<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");		
		
			if(session.getAttribute("username")==null)
				response.sendRedirect("login.jsp");	
		%>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<p style="margin-left:82%;margin-top:2%;">WELCOME ${username}</p>
			<form class="d-flex" action="logout">
				<button class="btn btn-outline-success" type="submit">Logout</button>
			</form>
		</div>
	</nav>
	<br>
	
	<form class="d-flex" action="addbook"method="post">
				<button class="btn btn-primary" type="submit" style="margin-left:80%;">Add the book</button>
			</form>
			
	<div style="margin-right:10%;margin-left:10%;margin-bottom:5%">
	
		<h4 style="text-align: center;">Books Listing</h4>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Book Code</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Added On</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach  items="${list}" var="book">
					<tr>
                  
                        <td><c:out value="${book.getBcode()}"/></td>
                        <td><c:out value="${book.getBname()}"/></td>
                        <td><c:out value="${book.getBauthor()}"/></td>
                        <td><c:out value="${book.getBdate()}"/></td>
                       
                                    
                       
						<td>     
						      <form action="updatebook" method="post">
						      <input type="hidden"name="bcode"value="${book.getBcode()}">
						      <input type="hidden"name="bname"value="${book.getBname()}">
						      <input type="hidden"name="bauthor"value="${book.getBauthor()}">
						      <input type="hidden"name="bdate"value="${book.getBdate()}">
								<button>Edit</button>
								</form>
						     <br>
						        <form action="deletebook">
						        <input type="hidden"name="bcode"value="${book.getBcode()}">
								<button>Delete</button>
								</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>