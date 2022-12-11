package aplicacao;

import java.util.Date;
import java.util.List;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.dao.implementacao.VendedorDaoJDBC;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		
		
		VendedorDao vd = FabricaDao.criarVendedorDao();
		
		Vendedor vendedor = vd.findById(3);
		
		System.out.println(vendedor);
		
		Departamento departamento = new Departamento(2, null);
		
		List<Vendedor> lista = vd.findByDepartamento(departamento);
		
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
		
	}

}
