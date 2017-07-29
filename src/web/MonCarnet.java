package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BM.AuthentificationBM;

/**
 * Servlet implementation class MonCarnet
 */
@WebServlet("/MonCarnet")
public class MonCarnet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonCarnet() {
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
