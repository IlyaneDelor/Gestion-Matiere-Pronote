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
@WebServlet("/deleteMatiere")
public class deleteMatiereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private MatiereDao matierelog;

     
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
		    public void init() {
		        matierelog = new MatiereDao();
		    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		  
        Matiere matiere = new Matiere();
        matiere.setId(id);
	    HttpSession session = request.getSession();
		
		matierelog.delete(matiere);
		
	    session.setAttribute("message", "Delete Successful");
	    request.getRequestDispatcher("viewMatiere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		
	}

}
