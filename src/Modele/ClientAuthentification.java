package Modele;

public class ClientAuthentification {

	private String pseaudoName;
	private String motDePasse;
	
	public ClientAuthentification() {
		// TODO Auto-generated constructor stub
	}

	public ClientAuthentification(String pseaudoName, String motDePasse) {
		super();
		this.pseaudoName = pseaudoName;
		this.motDePasse = motDePasse;
	}

	public String getPseaudoName() {
		return pseaudoName;
	}

	public void setPseaudoName(String pseaudoName) {
		this.pseaudoName = pseaudoName;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	@Override
	public String toString() {
		System.out.println(this.pseaudoName+ " " + this.motDePasse);
		return super.toString();
	} 
}
