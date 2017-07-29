package Modele;

import java.util.Date;

public class Client {

	private int idClient;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String login;
	private String motDePasse;
	
	
	
	
	public Client() {
		super();
	}


	
	public Client(String nom, String prenom, Date dateNaissance, String login, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.login = login;
		this.motDePasse = motDePasse;
	}



	public Client(int idClient, String nom, String prenom, Date dateNaissance, String login, String motDePasse) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.login = login;
		this.motDePasse = motDePasse;
	}
	
	
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance1) {
		this.dateNaissance = dateNaissance1;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println(this.nom + this.prenom + this.login + this.motDePasse);
		return this.nom + this.prenom + this.login + this.motDePasse;
	}
}
