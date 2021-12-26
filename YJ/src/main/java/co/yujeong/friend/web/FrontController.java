package co.yujeong.friend.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yujeong.friend.command.Command;
import co.yujeong.friend.command.FriendDeleteCommand;
import co.yujeong.friend.command.FriendDeleteFormCommand;
import co.yujeong.friend.command.FriendInsertCommand;
import co.yujeong.friend.command.FriendInsertFormCommand;
import co.yujeong.friend.command.FriendListCommand;
import co.yujeong.friend.command.FriendSearchCommand;
import co.yujeong.friend.command.FriendSearchFormCommand;
import co.yujeong.friend.command.FriendUpdateCommand;
import co.yujeong.friend.command.FriendUpdateFormCommand;
import co.yujeong.friend.command.MainCommand;

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
		map.put("/main.do", new MainCommand());
		map.put("/friendList.do", new FriendListCommand());
		map.put("/friendSearch.do", new FriendSearchCommand());
		map.put("/friendSearchForm.do", new FriendSearchFormCommand());
		map.put("/friendInsert.do", new FriendInsertCommand());
		map.put("/friendInsertForm.do", new FriendInsertFormCommand());
		map.put("/friendDelete.do", new FriendDeleteCommand());
		map.put("/friendDeleteForm.do", new FriendDeleteFormCommand());
		map.put("/friendUpdate.do", new FriendUpdateCommand());
		map.put("/friendUpdateForm.do", new FriendUpdateFormCommand());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());

		Command command = map.get(path);
		String viewPage = command.execute(request, response);

		if (!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
