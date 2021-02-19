package dao;

import java.sql.*;

import util.DatabaseConnect;

public class AllMusicDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rst;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	
	public ResultSet allmusic() {
		conn = databaseConnect.dbconnect();
		try {
			pst = conn.prepareStatement("select * from musicsystem_info",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}
}
