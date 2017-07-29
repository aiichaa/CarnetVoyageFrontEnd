package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectionDB {

	 private static Connection connection = null;
	 
	 public ConnectionDB() {
		// TODO Auto-generated constructor stub
	}

	    public static Connection getConnection() {
	     
	            try {
	            	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	            	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carnetVoyage","root","login");
	            	System.out.println("Connection effectuee");
	            	
	            	
	            } catch (Exception e) {
	            	System.out.println("Driver not found");
	                e.printStackTrace();
	            } 
	            
	            return connection;
	        }

	    
		
	    /*public static void main(String[] args) {
	    	
			Connection connection=ConnectionDB.getConnection();
			
		}
	    */
	    
	
		}


