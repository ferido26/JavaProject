package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {

	static Connection getConn() {
		
		String url="jdbc:mysql://127.0.0.1:3306/sms";
				
				Connection conn=null;
				
				try {
					conn=DriverManager.getConnection(url,"root","Kshitij@123");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				return conn;
		

	}

}
