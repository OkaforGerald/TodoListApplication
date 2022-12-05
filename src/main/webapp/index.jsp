<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="includes/header.jsp" %>
</head>
<body>
<div class="container">
<div class="card w-50 mx-auto my-5 bg-dark">
<div class ="card-header text-center text-white">LOGIN</div>
<div class = card-body>
<form action="login" method="post">
 <div class="form-group">
 <p class="text-light"><label for="userEmail">Email address</label></p>
 <input type="email" class="form-control" id="userEmail" name="email" placeholder="Provide email" autofocus required/>
 </div>
 <div class="form-group mt-3 my-3">
 <p class="text-light"><label for="pwd">Password</label></p>
 <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password" required/>
 </div>
 <div class="text-center">
 <button type="submit" class="mx-auto btn btn-danger">LOGIN</button>
 </div>
</form>
</div>
</div>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>