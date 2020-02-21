package music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class music_list
 */
@WebServlet("/music_list")
public class music_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public music_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String musicType = request.getParameter("musicType");
		List list = new ArrayList();
		if(musicType.equals("liuxing")) {
			list.add(new music("稻香"));
			list.add(new music("晴天"));
			list.add(new music("告白气球"));
		}else if(musicType.equals("jingdian")) {
			list.add(new music("千千阙歌"));
			list.add(new music("傻女"));
			list.add(new music("七友"));
		}else if(musicType.equals("yaogun")) {
			list.add(new music("一块红布"));
			list.add(new music("假行僧"));
			list.add(new music("新长征路上的摇滚"));
		}
		String json = JSON.toJSONString(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(json);
	}

	

}
