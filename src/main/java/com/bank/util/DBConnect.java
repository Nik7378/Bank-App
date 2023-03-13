package com.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnect {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aj_bank","root","");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
