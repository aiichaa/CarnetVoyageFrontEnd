package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RateServlet
 */
@WebServlet("/RateServlet")
public class RateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateServlet() {
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
	    String changerating = (String) request.getAttribute("changeRate");
	    
	    if(changerating != null){
	    	session.removeAttribute("rating");
	    	  session.setAttribute("login", login);
				 session.setAttribute("motDePasse", motDePasse);
				 
			request.setAttribute("login", login);
			request.setAttribute("motDePasse", motDePasse);

		    
			request.getRequestDispatcher("MonCarnet.jsp").forward(request, response);
	    }
	    else{

		    String rating = request.getParameter("rating");
		    request.setAttribute("rating", rating);
		    

			   session.setAttribute("login", login);
				 session.setAttribute("motDePasse", motDePasse);
				 session.setAttribute("rating", rating);
				 
			request.setAttribute("login", login);
			request.setAttribute("motDePasse", motDePasse);

		    
			request.getRequestDispatcher("MonCarnet.jsp").forward(request, response);
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
