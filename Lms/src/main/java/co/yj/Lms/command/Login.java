package co.yj.Lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yj.Lms.board.VO.BoardVO;
import co.yj.Lms.board.service.BoardService;
import co.yj.Lms.board.serviceImpl.BoardServiceImpl;
import co.yj.Lms.member.VO.MemberVO;
import co.yj.Lms.member.service.MemberService;
import co.yj.Lms.member.serviceImpl.MemberServiceImpl;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService dao = new MemberServiceImpl(); //멤버 테이블에 필요한 것
		BoardService boardDao = new BoardServiceImpl(); //게시판 테이블에 필요한 것
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberLogin(vo); // 아이디와 패스워드를 보내줄테니 나머지값이 니가 있다면 좀 채워줘라
		// 나머지값이 없으면 내가 보낸거라도 돌려줘
		String page = "";
		if (vo.getName() != null) {
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			List<BoardVO> list = new ArrayList<BoardVO>();
			list = boardDao.boardSelectList();
			request.setAttribute("boards", list);
			//세션은 세션객체에 담아두면 어플리케이션 전체에 사용가능
			page = "main.do";
			//초기페이지가 로그인 페이지고, 로그인이 성공하면 메인페이지로 가고, 아니라면 무한 로그인페이지가 뜬다(로그인 성공할때까지 로그인폼 화면으로만 간다)
		} else {
			page = "loginForm.do";
		}
		return page;
		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		request.setAttribute("id", id);
//		request.setAttribute("password", password);
//		return "main/home";
	}

}
