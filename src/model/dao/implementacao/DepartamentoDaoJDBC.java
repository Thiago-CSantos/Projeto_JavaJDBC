package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbExeption;
import model.dao.DepartamentoDao;
import model.entidades.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao{

	private Connection conn;
	
	public DepartamentoDaoJDBC(Connection connection) {
		this.conn = connection;
	}

	@Override
	public void inserir(Departamento objeto) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)");
			
			st.setString(1, objeto.getNome());
			
			int linhasAlteradsa = st.executeUpdate();
			
			System.out.println(linhasAlteradsa);
		}
		
		catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		}
		
	}

	@Override
	public void atualizar(Departamento objeto) {
		
		try {
			PreparedStatement st = null;
			
			st = conn.prepareStatement("UPDATE department SET Name = ? where Id = ?");
			
			st.setString(1, objeto.getNome());
			st.setInt(2, objeto.getId());
			
			int linhasAlteradsa = st.executeUpdate();
			
			System.out.println(linhasAlteradsa);
		}
		catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		}
	}

	@Override
	public void deletarById(Integer id) {
		
		try {
			PreparedStatement st = null;
			
			st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			
			st.setInt(1, id);
			
			int linhasAlteradsa = st.executeUpdate();
			
			System.out.println(linhasAlteradsa);
		}
		catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		}
		
	}

	@Override
	public Departamento findById(Integer id) {
		
		try {
			PreparedStatement st = null;
			ResultSet rs = null;
			
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			
			st.setInt(1, id);
			
			 rs = st.executeQuery();
			 
			 if(rs.next()) {
				 Departamento dep = new Departamento();
				 dep.setId(rs.getInt("Id"));
				 dep.setNome(rs.getString("Name"));
				 return dep;
			 }
			 
			 return null; 
		}
		catch (SQLException e) {
			throw new DbExeption(e.getMessage());
		}
	}

	@Override
	public List<Departamento> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs =null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			
			rs = st.executeQuery();
			
			List<Departamento> lista = new ArrayList<>();
			
			while(rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("Id"));
				dep.setNome(rs.getString("Name"));
				
				lista.add(dep);
			}
			return lista;
		}
		
		catch(SQLException e) {
			throw  new DbExeption(e.getMessage());
		}
		
	}

}
