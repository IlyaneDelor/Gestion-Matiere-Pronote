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
 * Servlet implementation class deleteUserController
 */
@WebServlet("/deleteUser")
public class deleteUserController extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		  
        User user = new User();
        user.setId(id);
	    HttpSession session = request.getSession();
		
		userlog.delete(user);
		
	    session.setAttribute("message", "Delete Successful");
	    request.getRequestDispatcher("viewUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		
	}

}
