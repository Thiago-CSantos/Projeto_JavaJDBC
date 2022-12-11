package model.dao;

import db.DB;
import model.dao.implementacao.VendedorDaoJDBC;

public class FabricaDao {

	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection()); // função para se conectar ao banco
	}
	
}
