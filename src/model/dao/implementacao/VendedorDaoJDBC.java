package model.dao.implementacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.util.DnsSrv;

import db.DB;
import db.DbExeption;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{
	
	private Connection conn;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	public VendedorDaoJDBC(Connection conectar) {
		this.conn = conectar;
	}

	@Override
	public void inserir(Vendedor objeto) {
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES"
					+ "(?, ?, ?, ?, ?)");
			
			st.setString(1, objeto.getNome());
			st.setString(2, objeto.getEmail());
			st.setDate(3, new Date(objeto.getDataNascimento().getTime()));
			st.setDouble(4, objeto.getSalarioBase());
			st.setInt(5, objeto.getDepartamentos().getId());
			
			int linhasAfetadas = st.executeUpdate();
			
			System.out.println(linhasAfetadas);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		PreparedStatement st = null;
		ResultSet  rs = null;
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as NomeDepartamentos "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name;");
			
			rs = st.executeQuery();
			
			List<Vendedor> listaV = new ArrayList<>();
			
			while(rs.next()) {
				
				Departamento dep = new Departamento();
				
				dep.setId(rs.getInt("DepartmentId"));
				dep.setNome(rs.getString("NomeDepartamentos"));
				
				Vendedor vendedorObj = new Vendedor();
				
				vendedorObj.setDepartamentos(dep);
				
				vendedorObj.setId(rs.getInt("Id"));
				vendedorObj.setNome(rs.getString("Name"));
				vendedorObj.setEmail(rs.getString("Email"));
				vendedorObj.setDataNascimento(rs.getDate("BirthDate"));
				vendedorObj.setSalarioBase(rs.getDouble("BaseSalary"));
				
				listaV.add(vendedorObj);
			}
			return listaV;
		}
		catch(SQLException e) {
			throw new DbExeption(e.getMessage());
		}
	}

	
	
	
	@Override
	public List<Vendedor> findByDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
		
			st.setInt(1, departamento.getId());
			
			rs = st.executeQuery();
			
			List<Vendedor> listaV = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			
			while(rs.next()) {
				
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				
				if(dep == null) {
				
					dep = new Departamento();
					dep.setId(rs.getInt("DepartmentId"));
					dep.setNome(rs.getString("DepName"));
					
					map.put(rs.getInt("DepartmentId"), dep);
				 
				}
				Vendedor venObj = new Vendedor();
				
				venObj.setId(rs.getInt("Id"));
				venObj.setNome(rs.getString("Name"));
				venObj.setEmail(rs.getString("Email"));
				venObj.setSalarioBase(rs.getDouble("BaseSalary"));
				venObj.setDataNascimento(rs.getDate("BirthDate"));
				venObj.setDepartamentos(dep);
			
			 listaV.add(venObj);
			}
			return listaV;
		}
		
		catch(SQLException e) {
			throw new DbExeption(e.getMessage());
		}
	}

	
	
}
