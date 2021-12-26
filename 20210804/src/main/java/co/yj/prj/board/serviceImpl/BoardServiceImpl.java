package co.yj.prj.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yj.prj.board.service.BoardMapper;
import co.yj.prj.board.service.BoardService;
import co.yj.prj.board.vo.CommentsVO;
import co.yj.prj.board.vo.SnsVO;
import co.yj.prj.common.DataSource;

public class BoardServiceImpl implements BoardService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(); // Mybatis를 통해 DB와 연결 하겠다.
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class); // Mapper Interface를 사용

	@Override
	public List<SnsVO> snsSelectList() {
		// TODO Auto-generated method stub
		return map.snsSelectList();
	}

	@Override
	public List<SnsVO> snsSelect(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsSelect(vo);
	}

	@Override
	public CommentsVO commentsSelect(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.commentsSelect(vo);
	}

	@Override
	public int snsInsert(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsInsert(vo);
	}

	@Override
	public int snsDelete(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsDelete(vo);
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsUpdate(vo);
	}

	@Override
	public int CommentsInsert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.CommentsInsert(vo);
	}

	@Override
	public int CommentsDelete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.CommentsDelete(vo);
	}

	@Override
	public int CommentsUpdate(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.CommentsUpdate(vo);
	}
}
