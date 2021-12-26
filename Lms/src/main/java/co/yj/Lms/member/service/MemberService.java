package co.yj.Lms.member.service;

import java.util.List;

import co.yj.Lms.member.VO.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();

	MemberVO memberSelect(MemberVO vo);

	MemberVO memberLogin(MemberVO vo);

	int memberInsert(MemberVO vo);

	int memberDelete(MemberVO vo);

	int memberUpdate(MemberVO vo);
}
