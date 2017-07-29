package Modele;

import java.util.List;

public class Domaine {

	 private int domaineID;
	 
	   private String nom;
	   
	   private String description;
	   
	   private List<Activite> activites;
	   
	   public Domaine() {
		// TODO Auto-generated constructor stub
	}

	public int getDomaineID() {
		return domaineID;
	}

	public void setDomaineID(int domaineID) {
		this.domaineID = domaineID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}
	   
	   

}
