package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbExeption;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{
	
	private Connection conn;
	
	public VendedorDaoJDBC(Connection conectar) {
		this.conn = conectar;
	}

	@Override
	public void inserir(Vendedor objeto) {
		
		
	}

	@Override
	public void atualizar(Vendedor objeto) {
		
		
	}

	@Override
	public void deletarById(Integer id) {
		
		
	}

	@Override
	public Vendedor findById(Integer id) {
		
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
		
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setNome(rs.getString("DepName"));
				
				Vendedor venObj = new Vendedor();
				
				venObj.setId(rs.getInt("Id"));
				
				venObj.setNome(rs.getString("Name"));
				
				venObj.setEmail(rs.getString("Email"));
				
				venObj.setSalarioBase(rs.getDouble("BaseSalary"));
				
				venObj.setDataNascimento(rs.getDate("BirthDate"));
				
				venObj.setDepartamentos(dep);
				
				return venObj;
				
			}
			return null;
		}
		
		catch(SQLException e) {
			throw new DbExeption(e.getMessage());
		}
		
	}

	@Override
	public List<Vendedor> findAll() {
		
		return null;
	}

	
	
}
