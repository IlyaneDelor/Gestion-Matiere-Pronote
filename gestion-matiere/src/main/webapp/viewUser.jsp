<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Users</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header><body>  

    ${message }
<%@page import="net.ilyane.matiere.dao.*,net.ilyane.matiere.models.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Users List</h1>  
<a href="accueil.jsp">Accueil</a><br/>
  
<%  
List<User> list=UserDao.getAllUsers();  
request.setAttribute("list",list);  
%>  
  
<table border="1"  style="width:90%">  

<tr><th>Id</th><th>Username</th><th>Password</th><th>Prof</th>  

<th>Admin</th><th>Name</th><th>Edit</th><th>Delete</th></tr>  

<c:forEach items="${list}" var="u">  

<tr><td>${u.getId()}</td><td>${u.getUsername()}</td><td>${u.getPassword()}</td>  

<td>${u.getProf()}</td><td>${u.getAdmin()}</td><td>${u.getName()}</td> 
 
<td><a href="editForm.jsp?id=${u.getId()}">Edit</a></td>  

<td><a href="<%=request.getContextPath()%>/deleteUser?id=${u.getId()}">Delete</a></td></tr>  

</c:forEach>  
</table>  
<br/><a href="addUser.jsp">Add New User</a>  
  
</body>  
</html>  