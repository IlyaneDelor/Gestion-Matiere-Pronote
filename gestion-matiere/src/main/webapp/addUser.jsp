<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Add User Form</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header><body>
<a href="accueil.jsp">Accueil</a><br/>
<a href="viewUser.jsp">View All User</a><br/>  
  
<h1>Add New User</h1>  
<form action="<%=request.getContextPath()%>/addUser" method="post">  
   ${message }
 
<table>  
<tr><td>Username:</td><td><input type="text" name="username"/></td></tr>  
<tr><td>Password:</td><td>  
<input type="password" name="password"/></td></tr>  
<tr><td>Prof:</td><td>  

<input type="radio" name="prof" value="True"/>Yes   
<input type="radio" name="prof" value="False"/>No </td></tr>  

<tr><td>Admin:</td><td>  

<input type="radio" name="admin" value="True"/>Yes   
<input type="radio" name="admin" value="False"/>No </td></tr>  

<tr><td>Name:</td><td>  
<input type="text" name="name"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Add User"/></td></tr>  
</table>  
</form>  

</body>  
</html> 