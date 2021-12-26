package co.yj.prj.member.web;

import java.util.ArrayList;
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
		// 회원 전체 목록 보기
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = dao.memberSelectList();
		request.setAttribute("list", members);
		return "memberList";
	}

}
