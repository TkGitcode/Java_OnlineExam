package com.onlineexamconduction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
* @Author -- TkGitcode
*/
public class DataBase {
	public static final Connection getConnection()
	 {
		 Connection connection = null;
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexamconduction", "root", "1234");
		} catch (SQLException e) {
			System.out.println(e);
		}
		 return connection;
	 }
}
