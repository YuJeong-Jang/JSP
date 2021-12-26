package co.yj.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.prj.member.service.MemberService;
import co.yj.prj.member.serviceImpl.MemberServiceImpl;
import co.yj.prj.member.vo.MemberVO;

public class MemberSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 한명 조회
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo = dao.memberSelect(vo);
		if(vo.getName() != null) {
		request.setAttribute("member", vo);
		}
		return "memberSelect";
	}

}
