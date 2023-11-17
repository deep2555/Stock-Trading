package com.deepanshu.stockProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class userDB {
	
	static String url = "jdbc:sqlserver://DEEPANSHU-PRASH\\SQLEXPRESS;databaseName=tutorial;encrypt=true;trustServerCertificate=true;";
	/** database connection url **/
	static String userName = "deepanshu";
	static String password = "Newgen@01";

	public  static Connection getconnection() throws SQLException{
		
		Connection conn = DriverManager.getConnection(url,userName, password);
		System.out.println("Connected to SQL server database");
		
		
		return conn;

	}
	
	
}
