<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.onyeka.model.*" %>
	<%@page import="com.onyeka.DAO.*" %>
	<%@page import="com.onyeka.DBConnection.*" %>
	<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<% User auth=(User)request.getSession().getAttribute("auth");
	if(auth==null){
		response.sendRedirect("index.jsp");
	}
%>
<%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="card-header bg-dark">All Lists</div>
<div class="container">
	<table class="table table-dark">
	<thead>
	<tr>
	<th scope="col">Date added</th>
	<th scope="col">Description</th>
	<th scope="col">View Tasks</th>
	<th scope="col">Status</th>
	<th scope="col">Remove</th>
	</tr>
	</thead>
	<tbody>
	<%ListDAO ld=new ListDAO(DbConnection.getConnection());
		ArrayList<ListP> userList=(ArrayList<ListP>)request.getSession().getAttribute("sortList");
		for(ListP ls:userList){
	%>
	<tr>
	<td><%=ls.getDateCreated() %></td>
	<td><%=ls.getListName() %></td>
	<td><a href="" class="btn btn-primary">View Tasks</a></td>
	<td><%=1/5 %></td>
	<td><a class="btn btn-Remove" href="Remove?id=<%=ls.getListID() %>">Remove</a></td>
	</tr>
	<%} %>
	</tbody>
	</table>
</div>
<div class="bottom-right">
	<a href="newList.jsp" class="btn btn-danger">Create New List</a>
	</div>
<%@include file="includes/footer.jsp"%>
</body>
</html>