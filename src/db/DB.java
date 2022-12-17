package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	private static Properties carregarPropriedades() {
		try (FileInputStream fs = new FileInputStream("db.propriedades")){
			
			Properties props = new Properties();
			props.load(fs);
			return props;
			
		}
		catch (IOException e ) {
			throw new DbExeption(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties propriedade = carregarPropriedades();
				String url = propriedade.getProperty("dburl");
				conn = DriverManager.getConnection(url, propriedade);	
			} 
			catch (SQLException ex) {
				throw new DbExeption(ex.getMessage());
			}
		}
		return conn;
	}
	
	
	public static void fecharConexão(){
		
		if(conn != null) {
			try {
				conn.close();
			} 
			catch (SQLException ex) {
				throw new DbExeption(ex.getMessage());
			}
		}
		
	}
	
	public static void fecharStatement(Statement st) {
		
		if(st != null) {
			try {
				st.close();
			}
			catch(SQLException ex) {
				throw new DbExeption(ex.getMessage());
			}
		}
		
	}
	
	public static void fecharResultSet(ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				throw new DbExeption(ex.getMessage());
			}
		}
	}
	
	
}
