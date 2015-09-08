package main.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnector {

	public static Statement createDbConnector() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/harbase";
			String connectionUser = "admin";
			String connectionPassword = "admin";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return stmt;
	}
	
	
}
