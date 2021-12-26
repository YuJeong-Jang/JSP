package co.yj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yj.prj.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		HttpSession session = request.getSession();
		String message = session.getAttribute("name") + "님 정상 로그 아웃 되었습니다.";
//		session.invalidate(); // 세션을 새로 들어와라(세션을 삭제한다)
		session.removeAttribute("name");	//유효아이디 살아있다. 유니크하다.
		session.removeAttribute("author");
		request.setAttribute("message", message);
		return "member/memberError";
	}
}
