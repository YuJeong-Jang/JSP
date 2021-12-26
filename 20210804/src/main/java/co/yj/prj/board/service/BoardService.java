package co.yj.prj.board.service;

import java.util.List;

import co.yj.prj.board.vo.CommentsVO;
import co.yj.prj.board.vo.SnsVO;

public interface BoardService {
	List<SnsVO> snsSelectList();

	List<SnsVO> snsSelect(SnsVO vo);

	CommentsVO commentsSelect(CommentsVO vo);

	int snsInsert(SnsVO vo);

	int snsDelete(SnsVO vo);

	int snsUpdate(SnsVO vo);

	int CommentsInsert(CommentsVO vo);

	int CommentsDelete(CommentsVO vo);

	int CommentsUpdate(CommentsVO vo);

}
