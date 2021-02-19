package servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AllMusicDao;

@WebServlet("/AllMusicServlet")
public class AllMusicServlet extends HttpServlet {
	private AllMusicDao allMusicDao = new AllMusicDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rst = allMusicDao.allmusic();
		HttpSession session = request.getSession();
		session.setAttribute("result", rst);
		response.sendRedirect("allmusic.jsp");
	}


}
