<%@ page import="BM.ActiviteByDomaineBM" %> 
<%@ page import="Modele.Activite" %> 
<%@ page import="java.util.List" %>
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
String reservationID = (String) request.getAttribute("reservationID");

String nom = (String) request.getAttribute("nom");
String description = (String) request.getAttribute("description");
String maxUtilisateurString = (String) request.getAttribute("maxUtilisateur");
String coutString = (String) request.getAttribute("cout");
int maxUtilisateur = Integer.parseInt(maxUtilisateurString);
float cout = Float.parseFloat(coutString);

String modifier = (String) request.getAttribute("modifier"); 
String etat;


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
               <h3>Vous devez faire l'inscription ou s'authentification pour faire une reservation</h3>
               <%}
         
               else {%>
               
               
               
               <form action ="ReservationModificationServlet?activiteID=<% 
						out.println(activiteID);
                  %>&reservationID=<%out.println(reservationID);%>" method="post">
				<p>
				
				<table>
				
				<%
				String dateReservation = (String) request.getAttribute("dateReservation");
				String dureeJour = (String) request.getAttribute("dureeJour");
				String quantite = (String) request.getAttribute("quantite");

				%>
					
						<tr>	
						<td>Choisir la date de reservation :</td>
						<td><input type="date" name="dateReservation" value =<%= dateReservation %>></td>
					    </tr>	
					    
					    <tr>	
						<td>Duree en Jours :</td>
						<td><input type="number" name="dureeJour" value=<%= dureeJour %>></td>
					    </tr>
					    
					    <tr>	
						<td>Quantite :</td>
						<td><input type="number" name="quantite" value = <%= quantite %> ></td>
					    </tr>
					    
					    			
				</table>
				<table>
					<tr>
				
						<td><input type="submit" value="Modifier"></td>
						
					</tr>
				</table>
				</form>
				<%} %>
        
   </div>
  
  
  
  
  
  
  
  
  
  
  

</body>
</html>