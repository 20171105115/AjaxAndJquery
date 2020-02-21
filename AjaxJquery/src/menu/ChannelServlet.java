package menu;

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
 * Servlet implementation class ChannelServlet
 */
@WebServlet("/Channel")
public class ChannelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChannelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String level = request.getParameter("level");//哪一级频道
		String parent = request.getParameter("parent");//一级频道的编码
		List list = new ArrayList();
		if(level.equals("1")) {
			list.add(new Channel("ai","前沿/区块链/人工智能"));
			list.add(new Channel("web","前端/小程序/JS"));
		}else if(level.equals("2")) {
			if(parent.equals("ai")) {
				list.add(new Channel("micro","微服务"));
				list.add(new Channel("blockchain","区块链"));
				list.add(new Channel("other","..."));
			}else if(parent.equals("web")) {
				list.add(new Channel("html","HTML"));
				list.add(new Channel("css","小CSS"));
				list.add(new Channel("other","..."));
			}
		}
		String json = JSON.toJSONString(list);
		response.setContentType("test/html;charset=utf-8");
		response.getWriter().println(json);
	}



}
