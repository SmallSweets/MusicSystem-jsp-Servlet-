package dao;

import java.sql.*;

import entity.Music;
import util.DatabaseConnect;

public class AddMusicDao {
	private Connection conn;
	private PreparedStatement pst;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	
	public boolean add(Music music) {
		conn = databaseConnect.dbconnect();
		boolean result = false;
		try {
			pst = conn.prepareStatement("insert into musicsystem_info(Name,Singer,Time,Url) values(?,?,?,?)");
			pst.setString(1, music.getName());
			pst.setString(2, music.getSinger());
			pst.setString(3, music.getTime());
			pst.setString(4, music.getUrl());
			pst.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		return result;
	}
}
