<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
	</head>
	
	
	<header><h2>	<%= (session != null && session.getAttribute("name") != null) ? session.getAttribute("name").toString() : ""%> </h2></header>
	<body>
		  ${message }
		<h1>CONNECTED</h1>

		<%= (session != null && session.getAttribute("admin").toString() == "true") ?  "Admin : " : ""%>
		<%= (session != null && session.getAttribute("prof").toString() == "true") ?  "Prof : " : ""%>
		<%= (session != null && session.getAttribute("prof").toString() == "false" && session.getAttribute("admin").toString() == "false") ?  "Eleve : " : ""%>
		
		<% int id = (Integer)session.getAttribute("id"); %>
		<a href="login"><button>Deconnexion</button></a>
		
		<% if(session.getAttribute("admin").toString().equals("true")) { %> 
			<ul>
			  <li><a href="/gestion-matiere/viewUser.jsp">Gestion des comptes</a></li>
			  
			  <li><a href="/gestion-matiere/viewMatiere.jsp">Gestion des matières</a></li>
			  
	   		  <li><a href="/gestion-matiere/viewClassroom.jsp">Gestion des classes</a></li>
	   		  
	   		  <li><a href="/gestion-matiere/changePassword.jsp">Modifier votre mot de passe</a></li>

			  
			 
			</ul>
		<% } %>
			
		<% if(session.getAttribute("prof").toString().equals("true")) { %> 
			<ul>
			  <li><a href="viewDevoir.jsp">Gestion des devoirs</a></li>
			 
			 
			  
			  <li><a href="changePassword.jsp">Modifier votre mot de passe</a></li>
			   <li>Pour visualiser la moyenne de votre classe -> allez dans Gestion de classes</li>
			</ul>
		<% } %>
			
		<% if(session.getAttribute("prof").toString().equals("false") && session.getAttribute("admin").toString().equals("false")) { %> 
			<ul>
			  <li><a href="viewDevoirEleve.jsp">Voir ses notes</a></li>
			  <li><a href="viewDevoirMoyenne.jsp">Voir votre Moyenne</a></li>
			  
			  <li><a href="changePassword.jsp?id=${id}">Modifier votre mot de passe</a></li>
			</ul>
		<% } %>
		
	</body>
</html>