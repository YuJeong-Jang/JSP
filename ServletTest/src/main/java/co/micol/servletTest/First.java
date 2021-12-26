package co.micol.servletTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
//@WebServlet("/First")		//서버가 파일을 찾아 들어오는 주소를 알려주는 곳(일종의 네임텍임. 이걸 주석처리해버리면 서버가 이 파일을 읽을 수 없어서 로드를 하지 못함)
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
        super(); //부모생성자와 동일하게 생성자 생성하겠다
        // 생성자 (클래스 네임과 동일한 생성자)
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 요청객체, response 응답객체
		//get방식일때 처리해주는 메소드
		//포스트방식으로 들어온 것을 겟에서 변환해서 받으면 겟 형식으로 처리
		response.getWriter().append("Served at: ").append("나의 이름을 찍어보자");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식일때 처리해주는 메소드
		//포스트방식을 겟 형식으로 변환해서 겟으로 넘겨주면 겟 형태로 진행
		doGet(request, response);
	}

}
