package DAO;

import Modele.Client;
import Modele.ClientAuthentification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClientDAO {

	private Connection connection = ConnectionDB.getConnection();
	

	    public ClientDAO() {
	    
	    }

	    public void addClient(Client client) {
	    	
	    	SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
	    	PreparedStatement preparedStatement = null;   
	    	
	        try {
	        	
	        	 preparedStatement = connection.prepareStatement("insert into Client(nom,prenom,dateNaissance,pseudoName,motDePasse) values (?, ?, ?, ?, ?)");
	             preparedStatement.setString(1, client.getNom());
	             preparedStatement.setString(2, client.getPrenom());
	             //preparedStatement.setDate(3, new java.sql.Date(client.getDateNaissance().getTime()));
	             preparedStatement.setDate(3, java.sql.Date.valueOf(formatter.format(client.getDateNaissance())));
	             preparedStatement.setString(4, client.getLogin());
	             preparedStatement.setString(5, client.getMotDePasse());

	             preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    public ArrayList<ClientAuthentification> getAllClientAuthentification(){
	    	
	    	ArrayList<ClientAuthentification> list = new ArrayList<>();
			
			Statement myStmt = null;
			ResultSet myRs = null;
			
			try {
					myStmt = connection.createStatement();
					myRs = myStmt.executeQuery("select pseudoName,motDePasse from Client");
				
					while (myRs.next()) {
						ClientAuthentification clientAuthentification = convertRowToClientAuthentification(myRs);
						list.add(clientAuthentification); }
				return list;
				
			}catch (Exception e)
			{
				
					try {
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return null;
			}
	    	
	    }
	    
	    
	     private ClientAuthentification convertRowToClientAuthentification(ResultSet myRs) throws SQLException {
	    	
			String pseudoName = myRs.getString("pseudoName");
			String motDePasse = myRs.getString("motDePasse");

			ClientAuthentification tempClientAuthentification = new ClientAuthentification(pseudoName, motDePasse);
			
			return tempClientAuthentification;
		}
	     
	     
	     
	     
	     public List<Client> getAllClient(){
		    	
		    	List<Client> list = new ArrayList<Client>();
		    	
				
				Statement myStmt = null;
				ResultSet myRs = null;
				
				try {
						myStmt = connection.createStatement();
						myRs = myStmt.executeQuery("select * from Client");
						
					
						while (myRs.next()) {
							Client client = convertRowToClient(myRs);
							list.add(client);
							
						}
					return list;
					
				}catch (Exception e)
				{
						return null;
				}
		    	
		    }
		    
		    
		     private Client convertRowToClient(ResultSet myRs) throws SQLException {
		    	
		    	int idClient = myRs.getInt("clientId");
				String nom = myRs.getString("nom");
				String prenom = myRs.getString("prenom");
				java.util.Date dateNaissance = Util.dates.convertFromSQLDateToJAVADate(myRs.getDate("dateNaissance"));
				String pseudoName = myRs.getString("pseudoName");
                String motDePasse = myRs.getString("motDePasse");
				
                Client tempClient = new Client(idClient, nom, prenom,dateNaissance,pseudoName,motDePasse);
                
				return tempClient;
			}

		
	/*    
	 public static void main(String[] args) throws ParseException {
		  
		   String dateString = "01/08/1985";
		   String dateString1= "1999-04-03";
		   
		  Client c = new Client();

          Date d= Util.dates.convertionDate(dateString);
          Date d1=Util.dates.convertionDateFrom(dateString1);
          
		  c = new Client("mimi","momo",d1,"mimi","momo");
				ClientDAO dao = new ClientDAO();
				dao.addClient(c);
				
		 ClientDAO dao = new ClientDAO();
		 
		 ArrayList<ClientAuthentification> list = dao.getAllClientAuthentification();
		 
		 int k =0;
		 for(int i=0 ;i<list.size();i++){
			 if(list.get(i).getPseaudoName().equals("mimi")){
				 if(list.get(i).getMotDePasse().equals("momo")){
					 System.out.println("kayn"); 
				 }
			 }
		 }
		 if(k==1){
			 System.out.println("kayn");
		 }
		 
		 
		 ClientDAO dao = new ClientDAO();
		 List<Client> list = new ArrayList<Client>();
		 list = dao.getAllClient();
		 System.out.println(list.size());
			
		}*/

}
