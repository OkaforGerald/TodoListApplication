<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.onyeka.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New List</title>
<%@include file="includes/header.jsp"%>
<% User auth=(User)request.getSession().getAttribute("auth");
	if(auth==null){
		response.sendRedirect("index.jsp");
	}
%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="card w-50 mx-auto my-5 bg-dark">
			<div class="card-header text-center text-white">NEW LIST</div>
			<div class=card-body>
				<form action="NewList" method="post">
					<div class="form-group">
						<p class="text-light">
							<label for="desc">List Description</label>
						</p>
						<input type="text" class="form-control" id="desc" name="desc"
							placeholder="Provide a description" autofocus required />
					</div>
					<div class="text-center">
						<button type="submit" class="mx-auto btn btn-danger">CREATE</button>
					</div>
				</form>
			</div>
		</div>
		<div class="col-12 text-center">
			<b><a class="" href="home.jsp">CANCEL</a></b>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>