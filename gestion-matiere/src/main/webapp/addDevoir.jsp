<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Add Devoir Form</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header>
<body>  

<a href="accueil.jsp">Accueil</a><br/>
<body>
<a href="viewDevoir.jsp">View All Devoir</a><br/>  
  
<h1>Add New Devoir</h1>  
<form action="<%=request.getContextPath()%>/addDevoir" method="post">  
   ${message }
 
<table>  
<tr><td>Name :</td><td><input type="text" name="name"/></td></tr>  

<tr><td>Note :</td><td>  
<input type="number" name="note"/></td></tr>  

<tr><td>Eleve :</td><td>  
<input type="number" name="eleve"/></td></tr>

<tr><td>Matiere :</td><td>  
<input type="number" name="matiere"/></td></tr>


<tr><td colspan="2"><input type="submit" value="Add Devoir"/></td></tr>  
</table>  
</form>  

</body>  
</html>