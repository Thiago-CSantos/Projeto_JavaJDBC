package aplicacao;

import java.util.Date;

import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Departamento dt = new Departamento(1, "Books");
		Vendedor vd = new Vendedor(5, "Thiago", "thiago@gmail.com", new Date(), 2000.99, dt);
		
		
		System.out.println(vd);
		
	}

}
