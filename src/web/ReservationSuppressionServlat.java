package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BM.ReservationBM;

/**
 * Servlet implementation class ReservationSuppressionServlat
 */
@WebServlet("/ReservationSuppressionServlat")
public class ReservationSuppressionServlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationSuppressionServlat() {
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
			String reservationIdString = request.getParameter("reservationID");
			
			int reservationId = Integer.parseInt(reservationIdString);
			
			
			ReservationBM bm = new ReservationBM();
			bm.supprimerReservationById(reservationId);
			
			
			
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
