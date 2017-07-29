package web;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BM.AuthentificationBM;
import DAO.ClientDAO;
import DAO.ConnectionDB;
import Modele.ClientAuthentification;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login =request.getParameter("login");
		String motDePasse=request.getParameter("motDePasse");
	 
		
		//System.out.println(login);
	    // System.out.println(motDePasse);
			
	  //HttpSession session=request.getSession(true);  
	 
	  if(AuthentificationBM.isMemember(login, motDePasse)==true){
		  
		     HttpSession session=request.getSession();
		     session.setAttribute("login", login);
			 session.setAttribute("motDePasse", motDePasse);
			 
		    request.setAttribute("login", login);
			request.setAttribute("motDePasse", motDePasse);
            request.getRequestDispatcher("index.jsp").forward(request, response);
	  }
	
	  else {
		 
		    String message = "login ou mot de passe incorrect";
			request.setAttribute("message", message);
		  
			request.getRequestDispatcher("index.jsp").forward(request, response);
	  }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
