package co.micol.member.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.command.Command;
import co.micol.member.command.MainCommand;
import co.micol.member.command.MemberInsert;
import co.micol.member.command.MemberInsertForm;
import co.micol.member.command.MemberListCommand;
import co.micol.member.command.MemberSearchCommand;
import co.micol.member.command.MemberSearchForm;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController") //이걸안쓰면 서블릿을 매핑해주면 됨
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
		// command 객체들을 여기에 등록
		map.put("/Main.do", new MainCommand());	//홈
		map.put("/memberList.do", new MemberListCommand()); //회원 목록
		map.put("/memberSearch.do", new MemberSearchCommand()); //회원 검색
		map.put("/memberSearchForm.do", new MemberSearchForm()); //회원 검색 폼
		map.put("/memberInsertForm.do", new MemberInsertForm()); //회원 가입 폼
		map.put("/memberInsert.do", new MemberInsert()); //회원가입
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 여기가 실제 요청을 분석 및 처리, view Page 선택하는 곳
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		// 실제요청을 분석
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length()); // 실 요청문 예> main.do

		Command command = map.get(path); // Command command = new MainCommand();
		String viewPage = command.execute(request, response); // 실행될 결과를 보여줄 페이지

		if (!viewPage.endsWith(".do")) { // 보여줄 페이지를 선택
			viewPage = "WEB-INF/views/" + viewPage + ".jsp"; // view의 resolve역할(서버에서 돌고있으니까 접근가능한 것)
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
