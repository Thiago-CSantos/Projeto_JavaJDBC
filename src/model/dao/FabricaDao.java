package model.dao;

import model.dao.implementacao.VendedorDaoJDBC;

public class FabricaDao {

	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC();
	}
	
}
