package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeleteMusicDao;

@WebServlet("/DeleteMusicServlet")
public class DeleteMusicServlet extends HttpServlet {
	private DeleteMusicDao deleteMusicDao = new DeleteMusicDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("Id");
		deleteMusicDao.delete(Id);
		response.sendRedirect("AllMusicServlet");
	}


}
