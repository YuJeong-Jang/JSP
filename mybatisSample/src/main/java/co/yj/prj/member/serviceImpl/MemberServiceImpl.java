package co.yj.prj.member.serviceImpl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import co.yj.prj.common.DAO;
import co.yj.prj.member.service.MemberService;
import co.yj.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	// DAO 역할을 하는 것
	private SqlSession sqlSession = DAO.getInstance().openSession();

	@Override
	public List<MemberVO> memberSelectList() {
		// 회원리스트
		// mapper가 가지고 있는 id중에 해당하는 id값을 넣어주면된다
		return sqlSession.selectList("memberSelectList");
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 회원선택
		return sqlSession.selectOne("memberSelect", vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 회원가입
		return sqlSession.insert("memberInsert", vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 회원수정
		return sqlSession.update("memberUpdate", vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 회원삭제
		return sqlSession.delete("memberDelete", vo);
	}

}
