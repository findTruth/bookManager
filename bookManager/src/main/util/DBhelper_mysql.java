package main.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBhelper_mysql {
	private static String driver;
	private static String url;
	private static String uname;
	private static String pwd;
	private static String dbp = "DB.properties";
	static {
		Properties p = new Properties();
		try {
			p.load(DBhelper_mysql.class.getResourceAsStream(dbp));
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			uname = p.getProperty("uname");
			pwd = p.getProperty("pwd");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			 conn = DriverManager.getConnection(url, uname, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static boolean closeConnection(ResultSet rs,Statement s,Connection conn){
		try {
			if (rs!=null) {
				rs.close();
			}
			if(s!=null)
			s.close();
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
