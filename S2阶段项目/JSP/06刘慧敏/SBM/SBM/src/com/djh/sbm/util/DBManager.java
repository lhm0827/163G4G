package com.djh.sbm.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static Connection con;
	private static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url="jdbc:sqlserver://localhost:1433;databaseName=db_sbm";
	private static String uname="sa";
	private static String upassword="123456";


	public static Connection getConnection(){
		try {
			Class.forName(driverName);
			con=DriverManager.getConnection(url,uname,upassword);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}

