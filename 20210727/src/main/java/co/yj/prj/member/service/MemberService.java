package co.yj.prj.member.service;

import java.util.List;

import co.yj.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();

	MemberVO memberSelect(MemberVO vo);

	MemberVO memberLogin(MemberVO vo); // 로그인

	int memberInsert(MemberVO vo);

	int memberDelete(MemberVO vo);

	int memberUpdate(MemberVO vo);

}
