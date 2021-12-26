package co.yj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yj.prj.common.Command;
import co.yj.prj.member.service.MemberService;
import co.yj.prj.member.serviceImpl.MemberServiceImpl;
import co.yj.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 과정을 처리하는 곳
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(); // 세션 객체 호출
//		System.out.println(session.getId() + "==================="); //서버마다 시드타입을 받아서 표시해주므로 각각 숫자가 다르다(각각의 컴퓨터에서 각각의 서버)
//		//브라우저를 껐다가 다시 들어가면 다른 값.
//		//브라우저를 닫지 않고 새탭을 열어서 들어가면 같은 값.
//		//브라우저가 살아있다면 다른 계정으로 들어가도 같은 값.
//		//엣지와 크롬에서는 같은 계정이라도 각각 다른값
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberLogin(vo);
		String page = "";
		if(!vo.getName().isEmpty()) { //위아래 if문 같은 뜻임(단 앞에 !(not)을 붙여줘야함) -> 밸리데이션
//		if (vo.getName() != null) {
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId()); // 세션에 필요한 것들을 담아주자
			page = "member/loginSuccess";
		} else {
			String message = "존재하지 않는 아이디이거나 패스워드가 틀립니다.";
			request.setAttribute("message", message);
			page = "member/memberError";

		}
		return page;
	}

}
