<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Devoirs</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header><body>  
    ${message }
<%@page import="net.ilyane.matiere.dao.*,net.ilyane.matiere.models.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  <a href="accueil.jsp">Accueil</a><br/>
<h1>Devoirs List</h1>  
  
<%  
List<Devoir> list=DevoirDao.getAllDevoirs();
boolean test = (boolean)session.getAttribute("prof");
int id = (int)session.getAttribute("id");

request.setAttribute("list",list);  
%>  
  
<table border="1"  style="width:90%">  

<tr><th>Id</th><th>Name</th><th>Note</th><th>Eleve</th><th>Matiere</th><%if(test == true){ %><th>Edit</th><th>Delete</th> <%} %></tr>  

<c:forEach items="${list}" var="u">  

<tr><td>${u.getId()}</td><td>${u.getName()}</td><td>${u.getNote()}</td>  <td>${u.getEleve()}</td> <td>${u.getMatiere()}</td> 

 <%if(test == true){ %>
<td><a href="editFormDevoir.jsp?id=${u.getId()}">Edit</a></td>  

<td><a href="<%=request.getContextPath()%>/deleteDevoir?id=${u.getId()}">Delete</a></td> <%} %></tr>  

</c:forEach>  
</table>  
<%if(test == true){  %>
<br/><a href="addDevoir.jsp">Add New Devoir</a> <%} %>
  
</body>  
</html>  