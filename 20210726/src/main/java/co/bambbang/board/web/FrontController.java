package co.bambbang.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.bambbang.board.command.BoardList;
import co.bambbang.board.command.BoardSelect;
import co.bambbang.board.command.Command;
import co.bambbang.board.command.DeleteBoard;
import co.bambbang.board.command.DeleteForm;
import co.bambbang.board.command.HomeCommand;
import co.bambbang.board.command.InsertBoard;
import co.bambbang.board.command.InsertForm;
import co.bambbang.board.command.UpdateForm;
import co.bambbang.board.command.updateBoard;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
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
		// generate commands 커맨드 정의(생성)
		map.put("/home.do", new HomeCommand());
		map.put("/boardList.do", new BoardList());
		map.put("/boardSelect.do", new BoardSelect());
		map.put("/insertForm.do", new InsertForm());
		map.put("/insertBoard.do", new InsertBoard());
		map.put("/updateForm.do", new UpdateForm());
		map.put("/updateBoard.do", new updateBoard());
		map.put("/deleteForm.do", new DeleteForm());
		map.put("deleteBoard.do", new DeleteBoard());

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// actual request analize and return the page to show...
		// 실제 수행 부분 분석, 실행, 리턴페이지 돌려줌
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());

		Command command = map.get(path);
		String viewPage = command.execute(request, response);

		if (!viewPage.endsWith(".do")) {
			// making view resolve....
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
