<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JUMP Online Library</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">

		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-8">Welcome to JUMP Online Library</h1>
			</div>
		</div>
		<br>
		<c:choose>
			<c:when test="${ librarian != true }">
				<h1 class="display-3">Patron Sign In</h1>
			</c:when>

			<c:otherwise>
				<h1 class="display-3">Librarian Sign In</h1>
			</c:otherwise>
		</c:choose>

		<br>
		<form
			action="${ librarian != null ? 'librarian/loginLibrarian' : 'patron/loginPatron' }"
			method="post">
			<div class="form-group">
				<label for="userName">User Name</label> <input autocapitalize="off"
					autocorrect="off" type="text" class="form-control" id="userName"
					name="userName" required>
			</div>

			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<div style="padding: 1em 1em">
				<c:choose>
					<c:when test="${ librarian != true }">
						Not a Patron? <a href="<%=request.getContextPath()%>/patronSignin">Sign In</a> as Librarian	
			</c:when>
					<c:otherwise>
						Not a Librarian? <a href="<%=request.getContextPath()%>/librarianSignin">Sign
							In</a> as Patron
			</c:otherwise>
				</c:choose>
			</div>
			<button type="submit" class="btn btn-primary">Log In</button>
			<c:if test="${ librarian != true }">
			<button onclick="window.location.href='patronSignup.jsp' ;"
				type="button" class="btn btn-secondary">Sign Up</button>
			</c:if>
			<br> <br>

		</form>

	</div>

</body>
</html>
