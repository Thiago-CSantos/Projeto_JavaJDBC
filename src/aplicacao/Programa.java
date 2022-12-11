package aplicacao;

import java.util.Date;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		
		
		VendedorDao vd = FabricaDao.criarVendedorDao();
		
		Vendedor vendedor = vd.findById(3);
		
		System.out.println(vendedor);
		
	}

}
