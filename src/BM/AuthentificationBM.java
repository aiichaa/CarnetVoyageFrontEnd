package BM;

import java.util.ArrayList;
import java.util.List;

import DAO.ClientDAO;
import Modele.ClientAuthentification;

public class AuthentificationBM {

	public AuthentificationBM() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isMemember(String login, String motDePasse){
		ClientDAO clientdao = new ClientDAO();
		
		List<ClientAuthentification> list = clientdao.getAllClientAuthentification();
		
		for(int i =0 ;i<list.size(); i++){
			 if(list.get(i).getPseaudoName().equals(login)){
				 //System.out.println("inside first if");
				 if(list.get(i).getMotDePasse().equals(motDePasse)){
					 //System.out.println("inside second if");
						return true;
				 }
			 }
			
		
		}	
		return false;
		
	}
	
/*	public static void main(String[] args) {
		
			
	         
	         String login = "mimi";
	         String pass = "momo";
	         
	         if(AuthentificationBM.isMemember(login,pass)==true){
	        	 System.out.println("mimi is memeber");
	         }
	         else {

	        	 System.out.println("mimi is nooot memeber");
	         }
	         
		
	}*/
	
}
