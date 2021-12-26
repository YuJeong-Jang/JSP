package co.micol.member.service;

import java.util.List;

import co.micol.member.vo.MemberVO;

public interface MemberService {
//CRUD를 가지고 와야한다
	List<MemberVO> memberSelectList(); // 자바유틸 임포트, 회원전체 목록 보기(R)

	MemberVO memberSelect(MemberVO vo); // 한면의 회원을 조회(R)

	int memberInsert(MemberVO vo); // 회원 추가(C)

	int memberDelete(MemberVO vo); //회원 삭제(D)

	int memberUpdate(MemberVO vo); //회원 정보 변경(U)
}
