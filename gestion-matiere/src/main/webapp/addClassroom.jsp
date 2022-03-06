<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Add Classroom Form</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header>
<body>

<a href="accueil.jsp">Accueil</a><br/>

<a href="viewClassroom.jsp">View All Classroom</a><br/>  
  
<h1>Add New Classroom</h1>  
<form action="<%=request.getContextPath()%>/addClassroom" method="post">  
   ${message }
 
<table>  

<tr><td>Numero de la classe:</td><td>  
<input type="number" name="numberClass"/></td></tr>  

<tr><td>Eleve: (mettre ID de l'eleve, separe d'une virgule pour en ajouter d'autre)</td><td>  
<input type="text" name="eleve"/></td></tr>  

<tr><td>Prof :</td><td>  
<input type="number" name="prof"/></td></tr>  

<tr><td>Matiere :</td><td>  
<input type="number" name="matiere"/></td></tr>  


<tr><td colspan="2"><input type="submit" value="Add Classroom"/></td></tr>  
</table>  
</form>  

</body>  
</html> 