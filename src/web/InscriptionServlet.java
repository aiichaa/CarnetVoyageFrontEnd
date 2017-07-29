package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClientDAO;
import Modele.Client;
/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ClientDAO clientDao = new ClientDAO(); ;
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom =request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String dateNaissance=request.getParameter("dateNaissance");
		String login=request.getParameter("login");
		String motDePasse=request.getParameter("motDePasse");
		
		
		
		Client client = new Client();
			
			client.setNom(request.getParameter("nom"));
			client.setPrenom(request.getParameter("prenom"));
			
			String dateString = request.getParameter("dateNaissance");
			//String dateString = "2222-02-02";
			Date d= Util.dates.convertionDateFrom(dateString);
		   client.setDateNaissance(d);
			
			client.setLogin(request.getParameter("login"));
			client.setMotDePasse(request.getParameter("motDePasse"));
			
			
			
			clientDao.addClient(client);
		
			HttpSession session=request.getSession();
		     session.setAttribute("login", login);
			 session.setAttribute("motDePasse", motDePasse);
			 
		request.setAttribute("login", login);
		request.setAttribute("motDePasse", motDePasse);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
