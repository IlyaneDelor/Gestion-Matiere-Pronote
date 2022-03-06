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
Classroom u=ClassroomDao.getClassroomById(Integer.parseInt(id));

%>  
<a href="accueil.jsp">Accueil</a><br/>
  
<h1>Edit Form</h1>  

<form action="<%=request.getContextPath()%>/editClassroom" method="post">  

<input type="hidden" name="id" value="<%=u.getId() %>"/>  
<table>  

<tr><td>Numero de la classe:</td><td>  
<input type="number" name="numberClass" value="<%= u.getNumberClass()%>"/></td></tr>  


<tr><td>Eleve:  (mettre ID de l'eleve, separe d'une virgule pour en ajouter d'autre)</td><td>  
<input type="text" name="name" value="<%= u.getEleve()%>"/></td></tr>  

<tr><td>Prof:</td><td>  
<input type="number" name="prof" value="<%= u.getProf()%>"/></td></tr>  

<tr><td>Matiere:</td><td>  
<input type="number" name="matiere" value="<%= u.getMatiere()%>"/></td></tr>  


<tr><td colspan="2"><input type="submit" value="Edit Matiere"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  
