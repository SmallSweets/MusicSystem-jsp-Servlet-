package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String name = "root";
	private String password = "root";
	private String url = "jdbc:mysql:///musicsystem?serverTimezone=Asia/Shanghai";
	private Connection conn = null;
	
	public Connection dbconnect() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url,name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
