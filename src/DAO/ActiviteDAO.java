package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modele.Activite;
import Modele.ClientAuthentification;

public class ActiviteDAO {

	private Connection connection = ConnectionDB.getConnection();
	
	public ActiviteDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Activite> getAllActivite() throws Exception {
		
		List<Activite> list = new ArrayList<>();
		try {

			Statement myStmt = null;
			ResultSet myRs = null;
			
			myStmt = connection.createStatement();
			myRs = myStmt.executeQuery("select * from activite");
			
			while (myRs.next()) {
				//System.out.println("boucle while");
				Activite tempActivite = convertRowToActivite(myRs);
				//tempActivite.toString();
				list.add(tempActivite);
			}
			/*for(int i=0;i<list.size();i++){
				list.get(i).toString();
			}
				*/	
		}catch(Exception e){
			System.out.println("exeptions");
		}
		
		
		return list;
	}
	
	
private Activite convertRowToActivite(ResultSet myRs) throws SQLException {
		
		int activiteId = myRs.getInt("activiteId");
		int domaineId = myRs.getInt("domaineId");
		String nom = myRs.getString("nom");
		String description = myRs.getString("description");
		int cout = myRs.getInt("cout");
		int maxUtilisateur = myRs.getInt("maxUtilisateur");


		Activite activite = new Activite(activiteId, domaineId, nom, description, cout, maxUtilisateur);
		
		return activite;
	}

	/*public static void main(String[] args) {
		ActiviteDAO dao = new ActiviteDAO();
		try {
			List<Activite> list = dao.getAllActivite();
			for(Activite i : list){
				i.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
}
