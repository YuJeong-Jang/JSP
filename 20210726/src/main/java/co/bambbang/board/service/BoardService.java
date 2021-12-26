package co.bambbang.board.service;

import java.util.List;

import co.bambbang.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList(); //all list
	BoardVO boardSelect(BoardVO vo); //one article
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
}
