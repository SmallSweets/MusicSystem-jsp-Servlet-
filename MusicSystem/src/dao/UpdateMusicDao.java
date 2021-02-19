package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Music;
import util.DatabaseConnect;

public class UpdateMusicDao {
	private Connection conn;
	private PreparedStatement pst;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	
	public void updatemusic(Music music) {
		conn = databaseConnect.dbconnect();
		try {
			pst = conn.prepareStatement("update musicsystem_info set Name=?,Singer=?,Time=?,Url=? where Id = ?");
			pst.setString(1, music.getName());
			pst.setString(2, music.getSinger());
			pst.setString(3, music.getTime());
			pst.setString(4, music.getUrl());
			pst.setString(5, music.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
