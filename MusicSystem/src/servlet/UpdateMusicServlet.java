package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UpdateMusicDao;
import entity.Music;

@WebServlet("/UpdateMusicServlet")
public class UpdateMusicServlet extends HttpServlet {
	private Music music = new Music();
	private UpdateMusicDao updateMusicDao = new UpdateMusicDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		music.setId(request.getParameter("Id"));
		music.setName(request.getParameter("Name"));
		music.setSinger(request.getParameter("Singer"));
		music.setTime(request.getParameter("Time"));
		music.setUrl(request.getParameter("Url"));
		updateMusicDao.updatemusic(music);
		response.sendRedirect("success.jsp");
	}

}
