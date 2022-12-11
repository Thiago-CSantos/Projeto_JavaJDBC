package aplicacao;

import java.util.Date;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.dao.implementacao.VendedorDaoJDBC;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Departamento dt = new Departamento(1, "Books");
		Vendedor vd = new Vendedor(5, "Thiago", "thiago@gmail.com", new Date(), 2000.99, dt);
		
		VendedorDao vendedor = FabricaDao.criarVendedorDao();
		System.out.println(vd);
		
	}

}
