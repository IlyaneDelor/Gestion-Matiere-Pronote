package net.ilyane.matiere.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.ilyane.matiere.dao.*;


@WebServlet("/moyenneClass")
public class moyenneClassController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        String eleve = request.getParameter("eleve");
        double test= 0;
        int matiere = Integer.parseInt(request.getParameter("matiere"));
        try {
			 test = ClassroomDao.moyenneClass(eleve,matiere);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        
	    session.setAttribute("moyenne", test);
	    request.getRequestDispatcher("moyenneClassProf.jsp").forward(request, response);
        
        
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		}
}