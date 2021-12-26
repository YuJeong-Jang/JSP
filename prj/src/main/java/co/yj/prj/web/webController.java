package co.yj.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.prj.common.Command;
import co.yj.prj.common.MemberSelect;
import co.yj.prj.common.MemberSelectForm;
import co.yj.prj.member.web.MemberList;

@WebServlet("*.do")
public class webController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public webController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/memberList.do", new MemberList());
		map.put("/memberSelectForm.do", new MemberSelectForm());
		map.put("/memberSelect.do", new MemberSelect());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextpath = request.getContextPath();
		String page = uri.substring(contextpath.length());

		Command command = map.get(page);
		String viewPage = command.execute(request, response);

		if (!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
