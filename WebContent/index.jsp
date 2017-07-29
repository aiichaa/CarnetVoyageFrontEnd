<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

String activiteID;

%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MGVC</title>
<link rel="stylesheet" href="style.css" type="text/css" />



<% 

    String login = (String) request.getAttribute("login");
    String motDePasse = (String) request.getAttribute("motDePasse");
	String message = (String) request.getAttribute("message");


	
	
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
  
 
  
  
          <%
             if(login==null || motDePasse==null){
            	 
             
             %>
             
             <p><h1><center><font color=#244E8C>Bienvenue au MGVC</font></center></h1></p>
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
                         }else{
                        	 
                         
					  %>
					  <div>
  <ul>
     <li><a href="MonCarnet">Mon Carnet</a>    
     </li>
     </ul>
     </div>
        <%
      out.println("<h2> Bienvenue "+login+" :D </h2>");
      %>
					  <%}
                       %>
					  
					
					</div>
					
									
			
		<div id="slider">
			<figure>
            <img src="6.png">
            <img src="7.png">					
            <img src="8.png">					
            <img src="4.png">	
		    <img src="5.png">
           </figure>			
            </div>	
            
           	 
					

  
  </body>
  
  
  
</html>