package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modele.Reservation;
import Util.dates;

public class ReservationDAO {
	
private Connection connection = ConnectionDB.getConnection();

public ReservationDAO() {
	// TODO Auto-generated constructor stub
}

  public void addReservation(Reservation reservation){

		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
		  PreparedStatement preparedStatement = null;   
	  	
	      try {
	      	
	          preparedStatement = connection.prepareStatement("insert into Reservation(clientId,activiteId,dateReservation,dureeJour,quantite) values (?, ?, ?, ?, ?)");
	          preparedStatement.setInt(1, reservation.getIdClient());
	          preparedStatement.setInt(2, reservation.getIdActivite());
	          preparedStatement.setDate(3, java.sql.Date.valueOf(formatter.format(reservation.getDateReservation())));
	          preparedStatement.setInt(4, reservation.getDureeJour());
	          preparedStatement.setInt(5, reservation.getQuantite());

	          preparedStatement.executeUpdate();

	      } catch (SQLException e) {
	          e.printStackTrace();
	      }
	  
  }
   
  
  public List<Reservation> getAllReservation(){
  	
  	List<Reservation> list = new ArrayList<Reservation>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
				myStmt = connection.createStatement();
				myRs = myStmt.executeQuery("select * from Reservation");
			
				while (myRs.next()) {
					Reservation reservation = convertRowToReservation(myRs);
					list.add(reservation); }
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
  
  
   private Reservation convertRowToReservation(ResultSet myRs) throws SQLException {
  	
	    int idReservation = myRs.getInt("ReservationId");
	    int clientId = myRs.getInt("clientId");
	    int activiteId = myRs.getInt("activiteId");
	    Date dateReservation = Util.dates.convertFromSQLDateToJAVADate(myRs.getDate("dateReservation"));
		int dureeJour = myRs.getInt("dureeJour");
		int quantite = myRs.getInt("quantite");

		Reservation tempReservation = new Reservation(idReservation, clientId, activiteId, dateReservation, dureeJour,quantite);
		
		return tempReservation;
	}

   public void supprimerReservationById(int id){
 		PreparedStatement myStmt = null;

 		try {
 			myStmt = connection.prepareStatement("delete from Reservation where ReservationId=?");
 			
 			// set param
 			myStmt.setInt(1, id);
 			
 			// execute SQL
 			myStmt.executeUpdate();			
 		}catch(Exception e){
 			System.out.println("Failed delete reservation");
 		}
   }
   
   public  void modifierReservation(Reservation Newreservation) {
		PreparedStatement myStmt = null;
		
		try {
			// prepare statement
			myStmt = connection.prepareStatement("update reservation" + " set clientId=?, activiteId=?, dateReservation=?, dureeJour=?, quantite=?" + " where ReservationId=?");
			java.sql.Date sqlDate = dates.convertFromJavaToSQLDate(Newreservation.getDateReservation());
			
			// set params
			myStmt.setInt(1, Newreservation.getIdClient());
			myStmt.setInt(2, Newreservation.getIdActivite());
			myStmt.setDate(3, sqlDate);
			myStmt.setInt(4, Newreservation.getDureeJour());
			myStmt.setInt(5, Newreservation.getQuantite());
			myStmt.setInt(6, Newreservation.getIdReservation());
			
			// execute SQL
			myStmt.executeUpdate();	
			System.out.println("udpated vec succes");
		}catch(Exception e){
			System.out.println("failed to update reservation");
		}
 }
/*  public static void main(String[] args) {
	  ReservationDAO dao = new ReservationDAO();
	
	   List<Reservation> list = new ArrayList<Reservation>();
	   list = dao.getAllReservation();
	   
	 String dateString = "01/08/1985";

	    Date d= Util.dates.convertionDate(dateString);
	   
	  Reservation c = new Reservation(1,1,1,d,2,3);
	  
	  dao.addReservation(c);
	  
	  

    
    
}*/
	
}
