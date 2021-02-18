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
//		创建session对象
		HttpSession Session = request.getSession();
//		设置servlet接收数据的格式
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		rst = loginDao.login(name, password);
//			执行结果不为空 登录成功
			try {
				if (rst.next()) {
//					将成功登录的用户的用户名存放到session容器中
					Session.setAttribute("Name", name);
					Session.setAttribute("Password", password);
					response.sendRedirect("success.jsp");
//			执行结果为空 登录失败
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
