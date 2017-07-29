package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BM.ActiviteByIdBM;
import BM.ClientIDbyLogin;
import BM.ReservationBM;
import Modele.Activite;
import Modele.Reservation;

/**
 * Servlet implementation class ReservationModificationServlet
 */
@WebServlet("/ReservationModificationServlet")
public class ReservationModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationModificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

		
		//get all attributes
        HttpSession session=request.getSession(false); 
        String login =(String) session.getAttribute("login");
	    String motDePasse= (String) session.getAttribute("motDePasse");
		String reservationIdString = request.getParameter("reservationID");
		String activiteIdString = request.getParameter("activiteID");

       
		//get artivity information
		int activiteID = Integer.parseInt(activiteIdString);
		int reservationID = Integer.parseInt(reservationIdString);
		
		Activite activite = new Activite();
		ActiviteByIdBM bm = new ActiviteByIdBM();
		activite = bm.getActiviteById(activiteID);
		
	

		  //get les info et modifier et aller a mon carnet modifie
		   ClientIDbyLogin bm2 = new ClientIDbyLogin();
			int clientId = bm2.clientId(login);
		   Reservation reservation = new Reservation();
			ReservationBM resBM = new ReservationBM();
	
		String dureeJourString = request.getParameter("dureeJour");
		String quantiteString = request.getParameter("quantite");
     	int dureeJour = Integer.parseInt(dureeJourString);
		
	    int quantite = Integer.parseInt(quantiteString);

	   int idActivite = Integer.parseInt(activiteIdString);
		
	  /* System.out.println("***********************************");
	   System.out.println(quantite);
	   System.out.println(dureeJour);
	   System.out.println("***********************************");
*/
               /*here u have a problem it's not added in database*/
		
		String dateReservationString = request.getParameter("dateReservation");
		//String dateString = "2222-02-02";
		Date d= Util.dates.convertionDateFrom(dateReservationString);
		
	    reservation.setIdClient(clientId);
		reservation.setIdActivite(idActivite);
		reservation.setDateReservation(d);
		reservation.setDureeJour(dureeJour);
		reservation.setQuantite(quantite);
		
	        resBM.supprimerReservationById(reservationID);
	       resBM.addReservation(reservation);
			//resBM.modifierReservation(reservation);
			/*System.out.println("reservation updated in servlet");
			System.out.println(reservation.toString());
			*/
			
			
		    request.setAttribute("login", login);
		    request.setAttribute("motDePasse", motDePasse);
		    request.setAttribute("activiteID", activiteIdString);
		   /* 
		    request.setAttribute("nom", activite.getNom());
		    request.setAttribute("description", activite.getDescription());
		    request.setAttribute("maxUtilisateur", String.valueOf(activite.getMaxUtilisateur()));
		    request.setAttribute("cout", String.valueOf(activite.getCout()));

		    */
		
		
	       session.setAttribute("login", login);
			 session.setAttribute("motDePasse", motDePasse);
		    
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
