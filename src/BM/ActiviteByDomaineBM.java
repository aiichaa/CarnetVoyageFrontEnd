package BM;

import java.util.ArrayList;
import java.util.List;

import DAO.ActiviteDAO;
import Modele.Activite;

public class ActiviteByDomaineBM {

	ActiviteDAO dao = new ActiviteDAO();
	
	public ActiviteByDomaineBM() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Activite> activitesByDomaineID(int domaineID){
	
		try {
			List<Activite> listActivite = dao.getAllActivite();
			List<Activite> listActiviteDomaine = new ArrayList<Activite>();

			for(int i=0;i< listActivite.size();i++){
				if(listActivite.get(i).getDomaineID() == domaineID){
					listActiviteDomaine.add(listActivite.get(i));
				}
			}
			
			return listActiviteDomaine;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
			
		}
	
	}
	
	
	/*public static void main(String[] args) {
		ActiviteByDomaineBM bm = new ActiviteByDomaineBM();
		
		List<Activite> list1 = bm.activitesByDomaineID(1);
		List<Activite> list2 = bm.activitesByDomaineID(2);
		List<Activite> list3 = bm.activitesByDomaineID(3);
		List<Activite> list4 = bm.activitesByDomaineID(4);
		List<Activite> list5 = bm.activitesByDomaineID(5);
		
		for(Activite i : list1){
			i.toString();
		}

	}*/
}
