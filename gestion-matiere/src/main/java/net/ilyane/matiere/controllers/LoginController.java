package net.ilyane.matiere.controllers;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ilyane.matiere.models.*;
import net.ilyane.matiere.dao.*;


@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("password");
        session.removeAttribute("admin");
        session.removeAttribute("prof");
        session.removeAttribute("name");
        
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		// TODO Auto-generated method stub
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		if (username == null) { username = ""; } 
		if (password == null) { password = ""; } 
		

		
		List<User> acces=UserDao.getAllUsers();  
		for(int i=0; i<acces.size(); i++) {
			if( acces.get(i).getUsername() != null && acces.get(i).getPassword() != null ) {
				if( acces.get(i).getUsername().equals(username) && acces.get(i).getPassword().equals(password) ) {
					HttpSession session = request.getSession();
					
			        session.setAttribute("id", acces.get(i).getId());
			        session.setAttribute("username", acces.get(i).getUsername());
			        session.setAttribute("password", acces.get(i).getPassword());
			        session.setAttribute("prof", acces.get(i).getProf());
			        session.setAttribute("admin", acces.get(i).getAdmin());
			        session.setAttribute("name", acces.get(i).getName());
			        
				   
				    session.setAttribute("message", " Hello");
				    request.getRequestDispatcher("accueil.jsp").forward(request, response);
				}
				}
			}
			}
		}
