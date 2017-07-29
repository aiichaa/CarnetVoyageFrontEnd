package BM;

import java.util.ArrayList;
import java.util.List;

import DAO.ClientDAO;
import Modele.Client;

public class ClientIDbyLogin {
public ClientIDbyLogin() {
	// TODO Auto-generated constructor stub
}
    public int clientId(String login){
    	int id = 0;
    	
    	List<Client> list = new ArrayList<Client>();
    	ClientDAO dao = new ClientDAO();
    	list = dao.getAllClient();
    	for(int i=0;i<list.size();i++){
    		if(login.equals(list.get(i).getLogin())){

    			id=list.get(i).getIdClient();
    		}
    	}
    	return id;
    }
    
    
   /* public static void main(String[] args) {
		int id = 0;
		ClientIDbyLogin gg = new ClientIDbyLogin();
		id = gg.clientId("toto");
		System.out.println(id);
	}*/
}
