package co.yj.myHomePage.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.myHomePage.command.Command;
import co.yj.myHomePage.command.Home;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		Command command = map.get(page);
		String viewPage = command.execute(request, response);

		if (viewPage.startsWith("tiles:")) {
			viewPage = viewPage.substring(6) + ".tiles";
		} else if (!viewPage.endsWith(".do")) {
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
		}
		
//		if(!viewPage.endsWith(".do")) { //"home.do" 리다이렉트 됨
//			if(!viewPage.endsWith(".jsp")) {
//				viewPage = viewPage + ".tiles";
//			}else {			//타일즈 안태우는 방법(home/home)
//				viewPage = "/WEB-INF/views/" + viewPage;
//			}
//		} //->home.java에서 tiles: 부분 빼고 돌리면 됨 home/home.jsp하면 .do안탄다

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
