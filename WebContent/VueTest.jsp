<%
String nom =(String) request.getAttribute("nom");
String prenom=(String) request.getAttribute("prenom");
String dateNaissance=(String) request.getAttribute("dateNaissance");
String login=(String) request.getAttribute("login");
String motDePasse=(String) request.getAttribute("motDePasse");
//Integer id =Integer.parseInt(.getAttribute("id"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>inscription info</title>
</head>
<body>
  <h3>Votre nom est : <%=nom %> </h3>
   <h3>Votre prenom est : <%=prenom %> </h3>
     <h3>Votre date de naissance est : <%=dateNaissance %> </h3>
   <h3>Votre login est : <%=login %> </h3>
     <h3>Votre mot De Passe est : <%=motDePasse %> </h3>
     
     
     
        
    	   <form action ="RatingServlet?reservationID=<% //reservationID %>" method="post" >
           <input type="radio" name="rating" value="1" class="star">
           <input type="radio" name="rating" value="2" class="star">
           <input type="radio" name="rating" value="3" class="star">
           <input type="radio" name="rating" value="4" class="star">
           <input type="radio" name="rating" value="5" class="star">
           <input type="submit" value="Rate">
           </form>
    	   
    	
    
</body>
</html>