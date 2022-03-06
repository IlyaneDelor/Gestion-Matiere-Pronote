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
@WebServlet("/addMatiere")
public class addMatiereController extends HttpServlet {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 
        String name = request.getParameter("name");
        int coef = Integer.parseInt(request.getParameter("coef"));
    
  
        Matiere matiere= new Matiere();
        matiere.setName(name);
        matiere .setCoef(coef);


        if (name != "" && coef != (Integer)null ) {
		
        	HttpSession session = request.getSession(true);
        	matierelog.save(matiere);
		    session.setAttribute("message", "AccountCreated");
		    request.getRequestDispatcher("viewMatiere.jsp").forward(request, response);
		    
		} else {
			
		    HttpSession session = request.getSession();
		    session.setAttribute("message", "Account Error");
		    request.getRequestDispatcher("viewMatiere.jsp").forward(request, response);
		    //response.sendRedirect("login.jsp");
		
		}
    }
	}


