package aplicacao;

import java.util.Scanner;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartamentoDao departamento = FabricaDao.criarDepartamentoDao();
		
		
		System.out.println("---------INSERT-------\n"+"INSERIR DADOS:");
		Departamento dep1 = new Departamento(null, "Rexona");
		departamento.inserir(dep);

		
		System.out.println("---------Update-------\n"+"ATUALIZAR DADOS:");
		Departamento dep2 = new Departamento(5,"D2");
		departamento.atualizar(dep2);
		
		System.out.println("---------DELET-------\n"+"DELETAR DADOS:");
		System.out.println("Insira o id que deseja deletar: ");
		int idDepartamento = sc.nextInt();
		departamento.deletarById(idDepartamento);
		
		System.out.println("---------finById-------\n"+"ACHAR POR ID:");
		Departamento s = departamento.findById(2);
		System.out.println(s);
	}

}
