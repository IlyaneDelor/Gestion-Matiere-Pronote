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
@WebServlet("/deleteDevoir")
public class deleteDevoirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DevoirDao devoirlog;

     
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
		    public void init() {
		        devoirlog = new DevoirDao();
		    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		  
        Devoir devoir = new Devoir();
        devoir.setId(id);
	    HttpSession session = request.getSession();
		
		devoirlog.delete(devoir);
		
	    session.setAttribute("message", "Delete Successful");
	    request.getRequestDispatcher("viewDevoir.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		
	}

}
