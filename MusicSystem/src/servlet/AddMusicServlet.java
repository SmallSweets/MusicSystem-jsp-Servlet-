package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddMusicDao;
import entity.Music;

@WebServlet("/AddMusicServlet")
public class AddMusicServlet extends HttpServlet {
	private Music music = new Music();
	private AddMusicDao addMusicDao = new AddMusicDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		music.setName(request.getParameter("Name"));
		music.setSinger(request.getParameter("Singer"));
		music.setTime(request.getParameter("Time"));
		music.setUrl(request.getParameter("Url"));
		boolean result = addMusicDao.add(music);
		if (result) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
}
