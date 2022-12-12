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
		
		
		
		VendedorDao vd = FabricaDao.criarVendedorDao(); //Para se conectar com o banco 
		
		
		System.out.println("---------finById-------\n"+"ACHAR POR ID:");
		Vendedor vendedor = vd.findById(3);
		System.out.println(vendedor);
		
		
		System.out.println("---------finByDepartamento-------\n"+"ACHAR POR DepartmentId:");
		Departamento departamento = new Departamento(2, null);
		
		List<Vendedor> lista = vd.findByDepartamento(departamento);
		
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
		
		
		System.out.println("---------finAll-------\n"+"ACHAR TOTAL:");
		
		List<Vendedor> listaAll = vd.findAll();
		
		for(Vendedor OBJ : listaAll) {
			System.out.println(OBJ);
		}
		
		System.out.println("---------INSERT-------\n"+"INSERIR DADOS:");
		System.out.print("Linhas alteradas: ");
		
		Departamento depar = new Departamento(3, null);
		Vendedor vend = new Vendedor(null, "Denise", "denise@gmail.com", new Date(), 2000.99, depar);
		vd.inserir(vend);
		
		
		System.out.println("---------Update-------\n"+"ATUALIZAR DADOS:");
		Departamento dep = new Departamento(4, null);
		Vendedor vende = new Vendedor(12, "Alex", "alex@gmail.com", new Date(), 5000.00, dep);
		vd.atualizar(vende);
	}

}
