package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DatabaseConnect;

public class SearchMusicDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rst;
	private DatabaseConnect databaseConnect = new DatabaseConnect();
	private List<String> keys = new ArrayList<String>();
	
	public ResultSet search(String key) {
		conn = databaseConnect.dbconnect();
		keys.add("Name");
		keys.add("Singer");
		keys.add("Time");
		keys.add("Url");
		try {
//			�ֱ���ݲ�ͬ����������ѯ����
			for (int i = 0; i < keys.size(); i++) {
//				����ƶ�ָ��Ĺ��ܣ���Ҫ�����ز���
				pst = conn.prepareStatement("select * from musicsystem_info where "+keys.get(i)+" = '"+key+"'",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rst = pst.executeQuery();
				if (rst.next()) {
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}
}
