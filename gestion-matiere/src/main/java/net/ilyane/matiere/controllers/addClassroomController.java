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
@WebServlet("/addClassroom")
public class addClassroomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ClassroomDao classroomlog;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
	    public void init() {
	        classroomlog = new ClassroomDao();
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

 
        int numberClass = Integer.parseInt(request.getParameter("numberClass"));
        String eleve = request.getParameter("eleve");
        int prof = Integer.parseInt(request.getParameter("prof"));
        int matiere = Integer.parseInt(request.getParameter("matiere"));
        
        
        Classroom classroom= new Classroom();
        classroom.setNumberClass(numberClass);
        classroom.setEleve(eleve);
        classroom.setProf(prof);
        classroom.setMatiere(matiere);
        



        if ( eleve != "" ) {
		
        	HttpSession session = request.getSession(true);
        	classroomlog.save(classroom);
		    session.setAttribute("message", "AccountCreated");
		    request.getRequestDispatcher("viewClassroom.jsp").forward(request, response);
		    
		} else {
			
		    HttpSession session = request.getSession();
		    session.setAttribute("message", "Account Error");
		    request.getRequestDispatcher("viewClassroom.jsp").forward(request, response);
		    //response.sendRedirect("login.jsp");
		
		}
    }
	}


