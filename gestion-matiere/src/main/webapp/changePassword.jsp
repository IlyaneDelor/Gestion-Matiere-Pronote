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


int id=(int)session.getAttribute("id");  
User u=UserDao.getUserById(id);  
%>  
  
<h1>Edit Form</h1>  

<form action="<%=request.getContextPath()%>/editPassword" method="post">  
 ${message }
<input type="hidden" name="id" value="<%=u.getId() %>"/>  
<table>  



<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%= u.getPassword()%>"/></td></tr>  



<tr><td colspan="2"><input type="submit" value="Edit Password"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  
