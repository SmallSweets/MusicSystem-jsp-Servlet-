package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchMusicDao;

@WebServlet("/SearchMusicServlet")
public class SearchMusicServlet extends HttpServlet {
	
	private SearchMusicDao searchMusicDao = new SearchMusicDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		ResultSet rst = searchMusicDao.search(key);
		request.setAttribute("result", rst);
		request.getRequestDispatcher("searchmusic.jsp").forward(request, response);
	}
}
