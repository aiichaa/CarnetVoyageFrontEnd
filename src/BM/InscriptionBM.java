package BM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DAO.ClientDAO;
import DAO.ConnectionDB;
import Modele.Client;

public class InscriptionBM {
	
	private Connection connection = ConnectionDB.getConnection();
	
public InscriptionBM() {
	// TODO Auto-generated constructor stub
}


public void addClient(Client client) {
	
	ClientDAO dao = new ClientDAO();
	dao.addClient(client);
	

}

}
