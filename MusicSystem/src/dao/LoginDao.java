package dao;

import java.sql.*;

import util.DatabaseConnect;

public class LoginDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rst = null;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	
	public ResultSet login(String name,String password) {
		conn = databaseConnect.dbconnect();
		try {
			pst = conn.prepareStatement("select * from musicsystem_user where Name=? and Password=?");
			pst.setString(1, name);
			pst.setString(2, password);
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}
}
