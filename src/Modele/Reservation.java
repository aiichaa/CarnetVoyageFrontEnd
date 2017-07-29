package Modele;

import java.util.Date;

public class Reservation {

	private int idReservation;
	private int idClient;
	private int idActivite;
	private Date dateReservation;
	private int dureeJour;
	private int quantite;
	
	
	
	
	
	public Reservation() {
		super();
	}


	public Reservation(int idClient, int idActivite, Date dateReservation, int dureeJour, int quantite) {
		super();
		this.idClient = idClient;
		this.idActivite = idActivite;
		this.dateReservation = dateReservation;
		this.dureeJour = dureeJour;
		this.quantite = quantite;
	}


	public Reservation(int idReservation, int idClient, int idActivite, Date dateReservation, int dureeJour,
			int quantite) {
		super();
		this.idReservation = idReservation;
		this.idClient = idClient;
		this.idActivite = idActivite;
		this.dateReservation = dateReservation;
		this.dureeJour = dureeJour;
		this.quantite = quantite;
	}
	
	
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdActivite() {
		return idActivite;
	}
	public void setIdActivite(int idActivite) {
		this.idActivite = idActivite;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public int getDureeJour() {
		return dureeJour;
	}
	public void setDureeJour(int dureeJour) {
		this.dureeJour = dureeJour;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("cette reservation est du client id :"+this.idClient + "dureJour :"+this.getDureeJour());
		return super.toString();
	}
	 
}
