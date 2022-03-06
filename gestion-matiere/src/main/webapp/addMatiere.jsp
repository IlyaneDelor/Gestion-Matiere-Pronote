<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Add Matiere Form</title>  
</head>  
<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header><body>
<a href="accueil.jsp">Accueil</a><br/>
<a href="viewMatiere.jsp">View All Matiere</a><br/>  
  
<h1>Add New Matiere</h1>  
<form action="<%=request.getContextPath()%>/addMatiere" method="post">  
   ${message }
 
<table>  
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>  

<tr><td>Coef:</td><td>  
<input type="number" name="coef"/></td></tr>  


<tr><td colspan="2"><input type="submit" value="Add Matiere"/></td></tr>  
</table>  
</form>  

</body>  
</html> 