package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BM.ActiviteByDomaineBM;
import BM.ActiviteByIdBM;
import Modele.Activite;

/**
 * Servlet implementation class ActiviteServlet
 */
@WebServlet("/ActiviteServlet")
public class ActiviteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiviteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String login=request.getParameter("login");
	String motDePasse=request.getParameter("motDePasse");
	String activiteID = request.getParameter("activiteID");
	
	int id = Integer.parseInt(activiteID);
	
	Activite activite = new Activite();
	ActiviteByIdBM bm = new ActiviteByIdBM();
	activite = bm.getActiviteById(id);
	
	//System.out.println(activite.toString());
	
    request.setAttribute("login", login);
    request.setAttribute("motDePasse", motDePasse);
    request.setAttribute("activiteID", activiteID);
    
    request.setAttribute("nom", activite.getNom());
    request.setAttribute("description", activite.getDescription());
    request.setAttribute("maxUtilisateur", String.valueOf(activite.getMaxUtilisateur()));
    request.setAttribute("cout", String.valueOf(activite.getCout()));

    
    
    
  

	request.getRequestDispatcher("Activite.jsp").forward(request, response);
	           
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
