package model.dao;

import java.util.List;

import model.entidades.Vendedor;

public interface VendedorDao {

void inserir(Vendedor objeto);
	
	void atualizar(Vendedor objeto);
	
	void deletarById(Integer id);
	
	Vendedor findById(Integer id); //achar por Id
	
	List<Vendedor> findAll(); //achar tudo
	
}
