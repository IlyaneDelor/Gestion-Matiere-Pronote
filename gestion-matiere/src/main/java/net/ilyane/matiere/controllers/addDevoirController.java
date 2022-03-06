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
 * Servlet implementation class addUserController
 */
@WebServlet("/addDevoir")
public class addDevoirController extends HttpServlet {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 
        String name = request.getParameter("name");
        int note = Integer.parseInt(request.getParameter("note"));
        int eleve = Integer.parseInt(request.getParameter("eleve"));
        int matiere = Integer.parseInt(request.getParameter("matiere"));
    
  
        Devoir devoir= new Devoir();
        devoir.setName(name);
        devoir.setNote(note);
        devoir.setEleve(eleve);
        devoir.setMatiere(matiere);


        if (name != "" ) {
		
        	HttpSession session = request.getSession(true);
        	devoirlog.save(devoir);
		    session.setAttribute("message", "AccountCreated");
		    request.getRequestDispatcher("viewDevoir.jsp").forward(request, response);
		    
		} else {
			
		    HttpSession session = request.getSession();
		    session.setAttribute("message", "Account Error");
		    request.getRequestDispatcher("viewDevoir.jsp").forward(request, response);
		    //response.sendRedirect("login.jsp");
		
		}
    }
	}


