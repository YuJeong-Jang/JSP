package co.yj.memberProj.member.service;

import java.util.List;

import co.yj.memberProj.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> MemberSelectList();

	MemberVO MemberSelect(MemberVO vo);

	int memberInsert(MemberVO vo);

	int memberUpdate(MemberVO vo);

	int memberDelete(MemberVO vo);
}
