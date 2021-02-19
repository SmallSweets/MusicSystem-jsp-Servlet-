package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MusicInfoDao;

@WebServlet("/MusicInfoServlet")
public class MusicInfoServlet extends HttpServlet {
	private MusicInfoDao updateMusicDao = new MusicInfoDao(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("Id");
		ResultSet rst = updateMusicDao.seemusic(Id);
		HttpSession session = request.getSession();
		session.setAttribute("result", rst);
		response.sendRedirect("updatemusic.jsp");
	}
}
