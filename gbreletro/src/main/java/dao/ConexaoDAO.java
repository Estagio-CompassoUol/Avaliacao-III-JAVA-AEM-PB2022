package dao;

import java.awt.geom.GeneralPath;
import java.sql.Connection;


import factory.FactoryConnection;

public class ConexaoDAO {
	private Connection conn;
	
	public Connection getConn() {
		return conn;
	}
	
	public ConexaoDAO() {
		try {
			this.conn = new FactoryConnection().getConnection();
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e);
		}		
	}	
	
}
