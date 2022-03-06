<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header><body>  
<%@page import="net.ilyane.matiere.dao.*,net.ilyane.matiere.models.*"%>  
  
<%  
String id=request.getParameter("id");  
Matiere u=MatiereDao.getMatiereById(Integer.parseInt(id));  
%>  
  <a href="accueil.jsp">Accueil</a><br/>
<h1>Edit Form</h1>  

<form action="<%=request.getContextPath()%>/editMatiere" method="post">  

<input type="hidden" name="id" value="<%=u.getId() %>"/>  
<table>  

<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%= u.getName()%>"/></td></tr>  

<tr><td>Coef:</td><td>  
<input type="number" name="coef" value="<%= u.getCoef()%>"/></td></tr>  

<tr><td colspan="2"><input type="submit" value="Edit Matiere"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  
