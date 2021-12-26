package co.yj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.prj.common.Command;
import co.yj.prj.member.service.MemberService;
import co.yj.prj.member.serviceImpl.MemberServiceImpl;
import co.yj.prj.member.vo.MemberVO;

public class MemberSearch implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setCheck("search");
		request.setAttribute("member", memberDao.memberSelect(vo));
		return "member/memberSearchResult";
	}

}
