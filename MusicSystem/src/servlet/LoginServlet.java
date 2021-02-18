package servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.LoginDao;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private PreparedStatement pst;
	private ResultSet rst;
	private LoginDao loginDao = new LoginDao();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		����session����
		HttpSession Session = request.getSession();
//		����servlet�������ݵĸ�ʽ
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		rst = loginDao.login(name, password);
//			ִ�н����Ϊ�� ��¼�ɹ�
			try {
				if (rst.next()) {
//					���ɹ���¼���û����û�����ŵ�session������
					Session.setAttribute("Name", name);
					Session.setAttribute("Password", password);
					response.sendRedirect("success.jsp");
//			ִ�н��Ϊ�� ��¼ʧ��
				}else {
					response.sendRedirect("fail.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
