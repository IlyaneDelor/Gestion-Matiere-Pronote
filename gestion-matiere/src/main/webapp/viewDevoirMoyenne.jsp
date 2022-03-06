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
 

double u=DevoirDao.ViewDevoirsMoyennes((int)session.getAttribute("id"));  
%>  
  <br/><a href="accueil.jsp">Accueil</a>  
  
<h1>MOYENNE DE VOTRE ANNEE</h1>  

<H2>moyenne : <%out.println(u);%></H2>



  
</body>  
</html>  
