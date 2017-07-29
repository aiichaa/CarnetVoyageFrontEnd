package BM;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DAO.ConnectionDB;
import DAO.ReservationDAO;
import Modele.Reservation;
import Util.dates;

public class ReservationBM {
	
	static Connection connection = ConnectionDB.getConnection();
	
public ReservationBM() {
	// TODO Auto-generated constructor stub
}

public void addReservation(Reservation reservation){

  ReservationDAO dao = new ReservationDAO();
  dao.addReservation(reservation);
	  
  }
  
  public List<Reservation> getReservationByClientId(int ClientId){
	  
	  ReservationDAO dao = new ReservationDAO();
	  List<Reservation> list = new ArrayList<Reservation>();
	  List<Reservation> maList = new ArrayList<Reservation>();

	 
	  list = dao.getAllReservation();
	  
	  for(int i=0;i<list.size();i++){
		  if(list.get(i).getIdClient() == ClientId){
			  maList.add(list.get(i));
		  }
	  }
	  
	  return maList;
  }
  
  public Reservation getReservationById(int reservationID) throws SQLException{
	  
	  try{
		  ReservationDAO dao = new ReservationDAO();
		  List<Reservation> list = new ArrayList<Reservation>();
		  Reservation reservation = new Reservation();
		 
		  list = dao.getAllReservation();
		  
		  for(int i=0;i<list.size();i++){
			  if(list.get(i).getIdReservation() == reservationID){
				  reservation = list.get(i);
			  }
		  }
		  
		  return reservation;
	  }catch(Exception e){
		  System.out.println("Feiled to update");
		  return null;
	  }
	  
	  
  }
  
  public void supprimerReservationById(int id){
	   ReservationDAO dao = new ReservationDAO();
	   dao.supprimerReservationById(id);
  }
  
  public  void modifierReservation(Reservation Newreservation) {
	   ReservationDAO dao = new ReservationDAO();
       dao.modifierReservation(Newreservation);
  }
  
  public int getNumberReservationForActiviteID(int activiteID){
	  int nbrReservation = 0;
	  int quantite = 0;
	  ReservationDAO dao = new ReservationDAO();
	  List<Reservation> list = new ArrayList<Reservation>();	 
	  list = dao.getAllReservation();
	  
	  for(int i=0;i<list.size();i++){
		  if(list.get(i).getIdActivite() == activiteID){
			  quantite = list.get(i).getQuantite();
			  nbrReservation += quantite;
		  }
	  }
	  
	  return nbrReservation;
  }
  
  


/*public static void main(String[] args)  {
	ReservationBM bm = new ReservationBM();
  List<Reservation> maList = new ArrayList<Reservation>();
    maList = bm.getReservationByClientId(1);
    for(int i=0;i<maList.size();i++){
		 maList.get(i).toString();
	  }
  //System.out.println(maList.size());
  Reservation res1 = new Reservation();
  Reservation res2 = new Reservation();

  res1 = maList.get(1);
  System.out.println("iciaa");
  res1.setQuantite(9);
  System.out.println("icidddd6");

	
		
			bm.modifierReservation(res1);
		
		  System.out.println("icidddd6");

	//bm.supprimerReservationById(10);
		  System.out.println(bm.getNumberReservationForActiviteID(5));
	
}*/
 
}
