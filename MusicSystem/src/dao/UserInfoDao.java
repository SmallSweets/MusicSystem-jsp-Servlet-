package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseConnect;

public class UserInfoDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rst = null;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	
	public ResultSet seeinfo(String name,String password) {
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
