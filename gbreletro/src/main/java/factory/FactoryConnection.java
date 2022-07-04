package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
	public FactoryConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/gbreletro?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
   	 	String senha= "Gb2834*71";
   	 	
   	 	Connection conn = DriverManager.getConnection(url,usuario,senha);
   	 	
   	 	return conn;
	}
}
