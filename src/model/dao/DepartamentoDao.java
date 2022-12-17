package model.dao;

import java.util.List;

import model.entidades.Departamento;

public interface DepartamentoDao {

	void inserir(Departamento objeto);
	
	void atualizar(Departamento objeto);
	
	void deletarById(Integer id);
	
	Departamento findById(Integer id); //achar por Id
	
	List<Departamento> findAll(); //achar tudo
	
}
