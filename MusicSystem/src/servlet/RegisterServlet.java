package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDao;
import entity.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private User user = new User();
	private RegisterDao registerDao = new RegisterDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		user.setName(request.getParameter("Name"));
		user.setAddress(request.getParameter("Address"));
		user.setAge(request.getParameter("Age"));
		user.setPassword(request.getParameter("Password"));
		user.setSex(request.getParameter("Sex"));
		user.setPhone(request.getParameter("Phone"));
		boolean reuslt = registerDao.register(user);
		if (reuslt) {
			response.sendRedirect("index.jsp");
		}
	}

}
