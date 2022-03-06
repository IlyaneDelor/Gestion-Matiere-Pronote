<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Classrooms</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header><body>  
<a href="accueil.jsp">Accueil</a><br/>
    ${message }
<%@page import="net.ilyane.matiere.dao.*,net.ilyane.matiere.models.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Classroom List</h1>  
  
<%  
List<Classroom> list=ClassroomDao.getAllClassrooms();  
request.setAttribute("list",list); 


%>  
  
<table border="1" style="width:90%">  

<tr><th>Id</th><th>numberClass</th><th>Eleve</th><th>Prof</th><th>Matiere</th><th>MoyenneClasse<th>Edit</th><th>Delete</th></tr>  

<c:forEach items="${list}" var="u">  

<tr><td>${u.getId()}</td><td>${u.getNumberClass()}</td><td>${u.getEleve()}</td>  <td>${u.getProf()}</td>  <td>${u.getMatiere()}</td> 
<td><a href="<%=request.getContextPath()%>/moyenneClass?eleve=${u.getEleve()}&matiere=${u.getMatiere()} ">Moyenne Classe</a></td>
 
<td><a href="editFormClassroom.jsp?id=${u.getId()}">Edit</a></td>  

<td><a href="<%=request.getContextPath()%>/deleteClassroom?id=${u.getId()}">Delete</a></td></tr>  

</c:forEach>  
</table>  
<br/><a href="addClassroom.jsp">Add New Classroom</a>  
  
</body>  
</html>  