package net.ilyane.matiere.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ilyane.matiere.models.*;
import net.ilyane.matiere.dao.*;
/**
 * Servlet implementation class editUserController
 */
@WebServlet("/editUser")
public class editUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UserDao userlog;

     
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
		    public void init() {
		        userlog = new UserDao();
		    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean prof = Boolean.parseBoolean(request.getParameter("prof"));
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
        String name = request.getParameter("name");
  
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setProf(prof);
        user.setAdmin(admin);
        user.setName(name);
        

        if (username != "" || password != "" || name != "") {
		
        	HttpSession session = request.getSession(true);
             
		    userlog.update(user);
            
            
            
            
		    session.setAttribute("message", "Update Successful");
		    request.getRequestDispatcher("viewUser.jsp").forward(request, response);
		    
		} else {
			
		    HttpSession session = request.getSession();
		    session.setAttribute("message", "Update Error");
		    request.getRequestDispatcher("viewUser.jsp").forward(request, response);
		    //response.sendRedirect("login.jsp");
		
		}
        
     
	}

}
