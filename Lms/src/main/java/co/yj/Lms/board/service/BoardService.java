package co.yj.Lms.board.service;

import java.util.List;

import co.yj.Lms.board.VO.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList();

	BoardVO boardSelect(BoardVO vo);

	int boardInsert(BoardVO vo);

	int boardUpdate(BoardVO vo);

	int boardDelete(BoardVO vo);
}
