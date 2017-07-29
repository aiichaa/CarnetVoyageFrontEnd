package web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BM.ClientIDbyLogin;
import BM.ReservationBM;
import Modele.Reservation;



/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session=request.getSession(false); 
	       // HttpSession session=request.getSession();  
	        String login =(String) session.getAttribute("login");
		     String motDePasse= (String) session.getAttribute("motDePasse");
			String activiteIdString = request.getParameter("activiteID");
			
		
		
			ClientIDbyLogin bm = new ClientIDbyLogin();
			
			
			int clientId = bm.clientId(login);
			
			Reservation reservation = new Reservation();
			
			ReservationBM resBM = new ReservationBM();
			
			
		//System.out.println("la duree est" + request.getParameter("dureeJour"));
		
		String dureeJourString = request.getParameter("dureeJour");
		String quantiteString = request.getParameter("quantite");
		
		
		
		
		int dureeJour = Integer.parseInt(dureeJourString);
		
	    int quantite = Integer.parseInt(quantiteString);

	   int idActivite = Integer.parseInt(activiteIdString);
		

		
		String dateReservationString = request.getParameter("dateReservation");
		//String dateString = "2222-02-02";
		Date d= Util.dates.convertionDateFrom(dateReservationString);
		
	    reservation.setIdClient(clientId);
		reservation.setIdActivite(idActivite);
		reservation.setDateReservation(d);
		reservation.setDureeJour(dureeJour);
		reservation.setQuantite(quantite);
		
			
			resBM.addReservation(reservation);
			
		
		     session.setAttribute("login", login);
			 session.setAttribute("motDePasse", motDePasse);
			 
		request.setAttribute("login", login);
		request.setAttribute("motDePasse", motDePasse);

		request.getRequestDispatcher("MonCarnet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
