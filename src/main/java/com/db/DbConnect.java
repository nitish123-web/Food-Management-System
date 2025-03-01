package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	
	public static Connection get_connect() {
		Connection con=null;
		
		try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Nitish");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
