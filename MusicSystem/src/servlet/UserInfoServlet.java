package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfoDao;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private UserInfoDao userInfoDao = new UserInfoDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("Name");
		String password = (String)session.getAttribute("Password");
		ResultSet rst = userInfoDao.seeinfo(name, password);
		session.setAttribute("info", rst);
		response.sendRedirect("userinfo.jsp");
	}


}
