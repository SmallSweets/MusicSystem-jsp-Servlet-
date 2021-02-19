package dao;

import java.sql.*;

import util.DatabaseConnect;

public class MusicInfoDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rst;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	
	public ResultSet seemusic(String Id) {
		conn = databaseConnect.dbconnect();
		try {
			pst = conn.prepareStatement("select * from musicsystem_info where Id = ?");
			pst.setString(1, Id);
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}
}
