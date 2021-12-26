package co.yj.memberProj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yj.memberProj.common.DAO;
import co.yj.memberProj.member.service.MemberMapper;
import co.yj.memberProj.member.service.MemberService;
import co.yj.memberProj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DAO.getInstance().openSession();
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> MemberSelectList() {
		// TODO Auto-generated method stub
		return map.MemberSelectList();
	}

	@Override
	public MemberVO MemberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.MemberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		int n = map.memberInsert(vo);
		sqlSession.commit();
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		int n = map.memberUpdate(vo);
		sqlSession.commit();
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		int n = map.memberDelete(vo);
		sqlSession.commit();
		return n;
	}

}
