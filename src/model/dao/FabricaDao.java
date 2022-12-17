package model.dao;

import db.DB;
import model.dao.implementacao.DepartamentoDaoJDBC;
import model.dao.implementacao.VendedorDaoJDBC;

public class FabricaDao {

	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection()); // função para se conectar ao banco
	}
	
	public static  DepartamentoDao criarDepartamentoDao() {
		return new DepartamentoDaoJDBC(DB.getConnection()); // função para se conectar ao banco
	}
	
}
