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
<title>Tasks</title>
<% User auth=(User)request.getSession().getAttribute("auth");
	if(auth==null){
		response.sendRedirect("index.jsp");
	}
%>
<%@include file="includes/header.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="card-header bg-dark">All Tasks</div>
<div class="container">
	<table class="table table-dark">
	<thead>
	<tr>
	<th scope="col">Date added</th>
	<th scope="col">Description</th>
	<th scope="col">Status</th>
	<th scope="col">Reminder</th>
	<th scope="col">Remove</th>
	</tr>
	</thead>
	<tbody>
	<%
	TaskDAO td=new TaskDAO(DbConnection.getConnection());
		ArrayList<Task> userTask=td.getAllTasks(auth.getUserId());
		for(Task ts:userTask){
	%>
	<tr>
	<td><%=ts.getDateCreated() %></td>
	<td><%=ts.getTaskName() %></td>
	<% if(ts.isCompleted()){%>
	<td><button class="btn btn-success">Completed</button> </td>
	<%}else{ %>
	<td><a href="MarkCompleteAll?TaskID=<%=ts.getTaskID()%>" class="btn btn-primary">Mark as Complete</a></td>
	<%} %>
	<td><a href="" class="btn btn-sm btn-danger">Set Reminder</a></td>
	<td><a class="btn btn-Remove" href="removeTask?id=<%=ts.getTaskID() %>">Remove</a></td>
	</tr>
	<%} %>
	</tbody>
	</table>
</div>

<div class="bottom-right">
	<a href="newTask.jsp" class="btn btn-danger">Create New Task</a>
	</div>
<%@include file="includes/footer.jsp"%>
</body>
</html>