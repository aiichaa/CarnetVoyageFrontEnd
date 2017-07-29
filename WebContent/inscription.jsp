<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MGVC</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>

<body>

 <div>
  <ul>
     <li><a href="#">Hebergement</a>
     
     </li>
     <li><a href="#">Sport</a>
    
     </li>
     <li><a href="#">Restauration</a>
        
     </li>
     <li><a href="#">Recreativite</a>
        
     </li>
     <li><a href="#">Bien-etre</a>
     </li>
  </ul>      
  </div>

  <br/>
  
    <br/>

				<form action ="InscriptionServlet" method="post">
				<p>
				<h3>Vous devez faire l'inscription sur le site pour consulter les activites offertes</h3>
				<table>
					<tr>
						<td>Nom:</td>
						<td><input name="nom" type="text" size="30"></td>
					</tr>
					<tr>	
						<td>Prénom:</td>
						<td><input name="prenom" type="text" size="30"></td>
					</tr>
						<tr>	
						<td>Date Naissance:</td>
						<td><input type="date" name="dateNaissance"></td>
					</tr>				
					<tr>	
						<td>Login:</td>
						<td><input name="login" type="text" size="20"></td>
					</tr>
					<tr>	
						<td>Mot de passe:</td>
						<td><input name="motDePasse" type="password" maxlength="8" size="20"></td>
					</tr>
				</table>
				<table>
					<tr>
						<td><input type="submit" value="Valider"></td>
					</tr>
				</table>
				</form>






  
  </body>
</html>