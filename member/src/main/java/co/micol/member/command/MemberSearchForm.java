package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberSearchForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원조회 폼
		return "member/memberSearchForm";
	}

}
