package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.User;
import util.DatabaseConnect;

public class UpdateUserinfoDao {
	private Connection conn;
	private PreparedStatement pst;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	
	public boolean update(User user) {
		conn = databaseConnect.dbconnect();
		boolean result = false;
		try {
			pst = conn.prepareStatement("update musicsystem_user set Name=?,Password=?,Age=?,Address=?,Sex=?,Phone=?");
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getAge());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getSex());
			pst.setString(6, user.getPhone());
			pst.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
