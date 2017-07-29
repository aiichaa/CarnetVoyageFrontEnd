package BM;

import java.util.List;

import DAO.ActiviteDAO;
import Modele.Activite;

public class ActiviteByIdBM {

	ActiviteDAO dao = new ActiviteDAO();
	
	public ActiviteByIdBM() {
		// TODO Auto-generated constructor stub
	}
	
	public Activite getActiviteById(int activiteID){
			
		try {
			List<Activite> listActivite = dao.getAllActivite();
			Activite activite = new Activite();

			for(int i=0;i< listActivite.size();i++){
				if(listActivite.get(i).getActiviteID() == activiteID){
					activite = listActivite.get(i);
				}
			}
			
			return activite;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
			
		}
		
	}
	
	
	/*public static void main(String[] args) {
		Activite activite = new Activite();
		ActiviteByIdBM bm = new ActiviteByIdBM();
		activite = bm.getActiviteById(1);
		activite.toString();
		
	}*/
}
