<%@ page import="BM.ActiviteByDomaineBM" %> 
<%@ page import="Modele.Activite" %> 
<%@ page import="java.util.List" %>
<%@ page import="BM.ReservationBM" %>


<%
ActiviteByDomaineBM bm = new ActiviteByDomaineBM();

List<Activite> list1 = bm.activitesByDomaineID(1);
List<Activite> list2 = bm.activitesByDomaineID(2);
List<Activite> list3 = bm.activitesByDomaineID(3);
List<Activite> list4 = bm.activitesByDomaineID(4);
List<Activite> list5 = bm.activitesByDomaineID(5);


%> 

<%

String login=(String) session.getAttribute("login");
String motDePasse=(String) session.getAttribute("motDePasse");
String activiteID = (String) request.getAttribute("activiteID");

String message = (String) request.getAttribute("message");

String nom = (String) request.getAttribute("nom");
String description = (String) request.getAttribute("description");
String maxUtilisateurString = (String) request.getAttribute("maxUtilisateur");
String coutString = (String) request.getAttribute("cout");
int maxUtilisateur = Integer.parseInt(maxUtilisateurString);
float cout = Float.parseFloat(coutString);


%>

<%
ReservationBM resbm = new ReservationBM();
int nbrReservation = resbm.getNumberReservationForActiviteID(Integer.parseInt(activiteID));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MGVC</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>

<div id="accueil_image"></div>


  <div>
  <ul>
       <%
       
       out.println("<li><a>Hebergement</a>");
       out.println("<ul>");
       for(int i=0;i<list1.size();i++){
    	   out.println("<li><a href= "+"ActiviteServlet?activiteID="+String.valueOf(list1.get(i).getActiviteID())+">"+list1.get(i).getNom()+"</a></li>");
    	   //request.setAttribute("activiteID", String.valueOf(list1.get(i).getActiviteID()));
       }
       out.println("</ul>");
       out.println("</li>");
       
       out.println("<li><a>Sport</a>");
       out.println("<ul>");
       for(int i=0;i<list2.size();i++){
    	   out.println("<li><a href= "+"ActiviteServlet?activiteID="+String.valueOf(list2.get(i).getActiviteID())+">"+list2.get(i).getNom()+"</a></li>");
    	   //request.setAttribute("activiteID", String.valueOf(list2.get(i).getActiviteID()));
       }
       out.println("</ul>");
       out.println("</li>");
       
       out.println("<li><a>Restauration</a>");
       out.println("<ul>");
       for(int i=0;i<list3.size();i++){
    	   out.println("<li><a href= "+"ActiviteServlet?activiteID="+String.valueOf(list3.get(i).getActiviteID())+">"+list3.get(i).getNom()+"</a></li>");
    	   //request.setAttribute("activiteID", String.valueOf(list3.get(i).getActiviteID()));
       }
       out.println("</ul>");
       out.println("</li>");
       
       
       out.println("<li><a>Recreativite</a>");
       out.println("<ul>");
       for(int i=0;i<list4.size();i++){
    	   out.println("<li><a href= "+"ActiviteServlet?activiteID="+String.valueOf(list4.get(i).getActiviteID())+">"+list4.get(i).getNom()+"</a></li>");
    	   //request.setAttribute("activiteID", String.valueOf(list4.get(i).getActiviteID()));
       }
       out.println("</ul>");
       out.println("</li>");
       
       
       out.println("<li><a>Bien-etre</a>");
       out.println("<ul>");
       for(int i=0;i<list5.size();i++){
    	   out.println("<li><a href= "+"ActiviteServlet?activiteID="+String.valueOf(list5.get(i).getActiviteID())+">"+list5.get(i).getNom()+"</a></li>");
    	   //request.setAttribute("activiteID", String.valueOf(list5.get(i).getActiviteID()));
       }
       out.println("</ul>");
       out.println("</li>");
          
       %>
   
  </ul>      
  </div>
  
  <% if(login!=null || motDePasse!=null){
                        	 
                         
					  %>
					  <div>
					    <ul>
     <li><a href="MonCarnet">Mon Carnet</a>    
     </li>
     </ul>
     </div>
    
					  <%}
                       %>
					  
 
    <br/>
   <br/>
    <br/>
 <div id="info-part">
   
    
     <h3>nom activite : <%=nom %> </h3>
     <h3>description : <%=description %> </h3>
     <h3>cout  : <%=cout %> DH </h3>
        
        
         <%
             if(login==null || motDePasse==null){
             
             %>
              <br/>
              <br/>
               <font color = "red"><h4>Vous devez faire l'inscription ou s'authentification pour faire une reservation</h4></font>
               
               <%}
         
               else {%>
               
               
               
               <form action ="ReservationServlet?activiteID=<% 
						out.println(activiteID);
                  %>" method="post">
				<p>
				
				<table>
					
						<tr>	
						<td>Choisir la date de reservation :</td>
						<td><input type="date" name="dateReservation"></td>
					    </tr>	
					    
					    <tr>	
						<td>Duree en Jours :</td>
						<td><input type="number" name="dureeJour"></td>
					    </tr>
					    
					    <tr>	
						<td>Quantite :</td>
						<td><input type="number" name="quantite"></td>
					    </tr>
					    
					    			
				</table>
				<table>
				                     <%if(nbrReservation<maxUtilisateur){ %>
                 
					<tr>
						<td><input type="submit" value="Ajouter au Carnet"></td>
					</tr>
					<%} %>
				</table>
				</form>
				<%} %>
        
   </div>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
          <%
             if(login==null || motDePasse==null){
            	 
             
             %>
             
             
              <div id="authen-part">    
				<h2 ><font color=#082755 ><center>Authentification</center></font></h2>
               <div id="news-box">
					<form action ="AuthentificationServlet" method="post">
					   <table border="1">
		
							<tr>
								<td><font color=#082755><b>Login :</b></font></td>
								<td><div><input type="text" name="login" id="q" /></div></td>
							</tr>
							<tr>
								<td><font color=#082755><b>Password :</b></font></td>
								<td><div><input type="password" name="motDePasse" id="q" /></div></td>
							</tr>
							
						</table>
						<center><input type="submit" value="OK"></center>
						
						  <br />
					
					     <% 	if (message!=null){
										out.println("<font color=#ff3300>"+message+"!!!</font>");
									}	
							%>
										
									   
									   
					</form>
					</div>
					
							  <br />
	       <a href="inscription.jsp" title=""><center>S'inscrire</center></a>
					  <%
                         }
          %>
  

                 <%if(nbrReservation>=maxUtilisateur)
                 { out.println("<font color=#ff3300>Desole mais il parait qu'il n'y a plus de place pour cette activite ... veuillez verifiez plus tard!!!</font>");} %>
</body>
</html>