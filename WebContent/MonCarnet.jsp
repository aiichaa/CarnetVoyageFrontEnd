<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="BM.ActiviteByDomaineBM" %> 
<%@ page import="Modele.Activite" %> 
<%@ page import="Modele.Reservation" %>
<%@ page import="BM.ClientIDbyLogin" %>
<%@ page import="Util.dates" %>
<%@ page import="BM.ReservationBM" %> 
<%@ page import="BM.ActiviteByIdBM" %> 
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>

<%

String login = (String) request.getAttribute("login");
String motDePasse = (String) request.getAttribute("motDePasse");
String message = (String) request.getAttribute("message");

ClientIDbyLogin c = new ClientIDbyLogin();
ReservationBM r = new ReservationBM();
String rating = (String) session.getAttribute("rating");




int idClient = c.clientId(login);
List<Reservation> listReservation = r.getReservationByClientId(idClient);

ActiviteByIdBM activiteById = new ActiviteByIdBM();

%>
<%
ActiviteByDomaineBM bm = new ActiviteByDomaineBM();

List<Activite> list1 = bm.activitesByDomaineID(1);
List<Activite> list2 = bm.activitesByDomaineID(2);
List<Activite> list3 = bm.activitesByDomaineID(3);
List<Activite> list4 = bm.activitesByDomaineID(4);
List<Activite> list5 = bm.activitesByDomaineID(5);

String activiteID;

%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MGVC</title>
<link rel="stylesheet" href="style.css" type="text/css" />

<% 

 
	
	if(login!=null && motDePasse!=null){
		session.setAttribute("login", login);
		session.setAttribute("motDePasse", motDePasse);
		
	}
	
	
%>

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
     <div>
     <ul>
     <li><a href="MonCarnet">Mon Carnet</a>    
     </li>
     </ul>
     </div>
  
  
  
  
  
  
  <br/>
    <br/>
      <br/>
  <h1>Mes reservations</h1>
  
  
  
  
    <div>
  <ul>
       <%
       
       out.println("<ul>");
       float coutTotal = 0;
       for(int i=0;i<listReservation.size();i++){
          dates d = new dates();
    	   String s = d.getFormaDate(listReservation.get(i).getDateReservation());
    	   
           int activiteId = listReservation.get(i).getIdActivite();
           Activite activite = new Activite();
           activite = activiteById.getActiviteById(activiteId);
           String activiteNom = activite.getNom();
           float prixActivite = activite.getCout() * listReservation.get(i).getQuantite();
           out.println("<h3>");
    	   out.println("L'activite est : "+ activiteNom +" ... la date de reservation est le : "+s+" ...le prix total de cette activite est : "+prixActivite+" DH ... <a href= "+"ReservationSuppressionServlat?reservationID="+String.valueOf(listReservation.get(i).getIdReservation())+">Supprimer</a>...<a href= "+"ReservationModificationDonneeAncienne?reservationID="+String.valueOf(listReservation.get(i).getIdReservation())+"&activiteID="+String.valueOf(activite.getActiviteID())+">Modifier</a>");
    	   
    	
    	   out.println("</h3>");
    	   coutTotal += prixActivite; 
       }
        
       out.println("</ul>");
       out.println("</li>");
       
       
      %>
      </ul>
      </div>  
  
   <%
    out.println("<h2>Le cout Total de Votre Carnet est de : "+coutTotal+" DH</h2>");
   %>
  
  <% if(rating==null){ %>
  <form action="RateServlet" method="post">
            <input type="radio" name="rating" value="1" class="star">
            <input type="radio" name="rating" value="2" class="star">
            <input type="radio" name="rating" value="3" class="star">
            <input type="radio" name="rating" value="4" class="star">
            <input type="radio" name="rating" value="5" class="star">
            <input type="submit" value="Rate Us">
     </form>
  
  <%}else{ %>
  
  <center> <h3><font color="grey">votre rate etait : <%=rating %> Voulez vous le <a href ="RateServlet?changeRate=true"> modifier ?</a> </font></h3></center>
   
  <%} %>
  
   
           <a href="DeconnexionServlet" action="Post"> Se deconnecter</a>
  </body>
</html>