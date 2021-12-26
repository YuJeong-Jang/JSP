package co.yj.prj.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.prj.common.Command;
import co.yj.prj.member.service.MemberService;
import co.yj.prj.member.serviceImpl.MemberServiceImpl;
import co.yj.prj.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 
		MemberService memberDao = new MemberServiceImpl();
		List<MemberVO> list = memberDao.memberSelectList();
		request.setAttribute("members", list);
		return "member/MemberList";
	}

}
