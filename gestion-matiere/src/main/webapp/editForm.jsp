<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header><body>  
<a href="accueil.jsp">Accueil</a><br/>
<%@page import="net.ilyane.matiere.dao.*,net.ilyane.matiere.models.*"%>  
  
<%  

String id=request.getParameter("id");  
User u=UserDao.getUserById(Integer.parseInt(id));  
%>  
  
<h1>Edit Form</h1>  

<form action="<%=request.getContextPath()%>/editUser" method="post">  
 ${message }
<input type="hidden" name="id" value="<%=u.getId() %>"/>  
<table>  

<tr><td>Username:</td><td>  
<input type="text" name="username" value="<%= u.getUsername()%>"/></td></tr>  

<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%= u.getPassword()%>"/></td></tr>  

<tr><td>Prof</td><td>  
<input type="radio" name="prof" value="True" /> Yes
<input type="radio" name="prof" value="False "/> No </td></tr> 

<tr><td>Admin</td><td>  
<input type="radio" name="admin" value="True" /> Yes
<input type="radio" name="admin" value="False" /> No </td></tr>  

<tr><td> Name </td><td>  
<input type="text" name="name" value="<%= u.getName()%>"/></td></tr>  

<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  
