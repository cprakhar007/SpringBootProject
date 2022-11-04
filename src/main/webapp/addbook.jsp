<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*, java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
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
	<form action="addnewbook"method="post"
		style="text-align: center; margin-right: 15%; margin-left: 15%;">
		<div class="mb-3">
			<h4>Please enter book details</h4>
		</div>
		<div class="row mb-3">
			<label for="bookCode" class="col-sm-2 col-form-label">Book
				Code</label>
			<div class="col-sm-2"></div>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="bcode"
					id="bcode">
			</div>
		</div>
		<div class="row mb-3">
			<label for="bookName" class="col-sm-2 col-form-label">Book
				Name</label>
			<div class="col-sm-2"></div>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="bname"
					id="bookName">
			</div>
		</div>
		<fieldset class="row mb-3">
			<legend class="col-form-label col-sm-2 pt-0">Author</legend>
			<div class="col-sm-2"></div>
			<div class="col-sm-5">
				<select class="form-select" name="bauthor" id="author">
					<!-- <option selected value="">Select Author</option> -->
					<c:forEach items="${list}" var="author">
						<option value="${author.getBauthor()}">${author.getBauthor()}</option>
					</c:forEach>
				</select>
			</div>
		</fieldset>
		<div class="row mb-3">
			<label for="addedOn" class="col-sm-2 col-form-label">Added On</label>
			<div class="col-sm-2"></div>
			<div class="col-sm-5">
				<input type="text" name="bdate" class="form-control"
				
					id="addedOn" value="12 May 2022"disabled>
					<input type="hidden"name="bdate"value="12 May 2022">
			</div>
		</div>
		<div style="text-align: left;" class="row mb-3">
			<div class="col-sm-4"></div>
			<div class="col-sm-2">
				<button type="submit" class="btn btn-primary">Add Book</button>
			</div>
			<div class="col-sm-3">
				<a href="getbooks">
					<button type="button" class="btn btn-danger" value="Cancel">Cancel</button>
				</a>
			</div>
		</div>
	</form>
	<p style="color:red;margin-left:45%;">${message}</p>
</body>
</html>