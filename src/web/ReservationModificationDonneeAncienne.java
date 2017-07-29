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
 * Servlet implementation class ReservationModificationDonneeAncienne
 */
@WebServlet("/ReservationModificationDonneeAncienne")
public class ReservationModificationDonneeAncienne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationModificationDonneeAncienne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession(false); 
         String login =(String) session.getAttribute("login");
	     String motDePasse= (String) session.getAttribute("motDePasse");
		String reservationIdString = request.getParameter("reservationID");
		String activiteIdString = request.getParameter("activiteID");
		String reservationReponse = request.getParameter("modifier");
		String etat = request.getParameter("etat");

		int activiteID = Integer.parseInt(activiteIdString);
		int reservationID = Integer.parseInt(reservationIdString);
		
		Activite activite = new Activite();
		ActiviteByIdBM bm = new ActiviteByIdBM();
		activite = bm.getActiviteById(activiteID);
	    request.setAttribute("modifier", reservationReponse);
		
		
	    request.setAttribute("login", login);
	    request.setAttribute("motDePasse", motDePasse);
	    request.setAttribute("activiteID", activiteIdString);
	    request.setAttribute("reservationID",reservationIdString );
	    
	    request.setAttribute("nom", activite.getNom());
	    request.setAttribute("description", activite.getDescription());
	    request.setAttribute("maxUtilisateur", String.valueOf(activite.getMaxUtilisateur()));
	    request.setAttribute("cout", String.valueOf(activite.getCout()));

		   session.setAttribute("login", login);
			 session.setAttribute("motDePasse", motDePasse);
			 
		request.setAttribute("login", login);
		request.setAttribute("motDePasse", motDePasse);
		//System.out.println("work this shit ");
		
		  if(request.getParameter("etat")==null){
                
			   //recupere les anciens donnees
			   ReservationBM resBM = new ReservationBM();
			   
			   Reservation oldReservation = new Reservation();
			   try {
				oldReservation = resBM.getReservationById(reservationID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   java.util.Date dateReservationJava = oldReservation.getDateReservation();
			   int dureeJour = oldReservation.getDureeJour();
			   int quantite = oldReservation.getQuantite();			   
			   String dateReservation = Util.dates.getFormaDate(oldReservation.getDateReservation());
			   
			   
			   request.setAttribute("dateReservation", dateReservation);
			   request.setAttribute("dureeJour", String.valueOf(dureeJour));
			   request.setAttribute("quantite", String.valueOf(quantite));

				request.getRequestDispatcher("ReservationModification.jsp").forward(request, response);
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
