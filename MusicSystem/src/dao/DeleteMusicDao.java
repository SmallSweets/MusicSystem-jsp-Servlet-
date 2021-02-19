package dao;

import java.sql.*;

import util.DatabaseConnect;

public class DeleteMusicDao {
	private Connection conn;
	private PreparedStatement pst;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	
	public void delete(String Id) {
		conn = databaseConnect.dbconnect();
		try {
			pst = conn.prepareStatement("delete from musicsystem_info where Id = ?");
			pst.setString(1, Id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
