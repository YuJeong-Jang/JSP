package com.yj.app.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yj.app.board.domain.BoardAttachVO;
import com.yj.app.board.domain.BoardVO;
import com.yj.app.board.domain.Criteria;

@Service
public interface BoardService {
	// CRUD(게시글)
	// 등록
	public int insert(BoardVO vo);

	// 수정
	public int update(BoardVO vo);

	// 삭제
	public int delete(BoardVO vo);

	// 단건조회
	public BoardVO read(BoardVO vo);

	// 전체조회
	public List<BoardVO> getList(Criteria cri);

	//전체 데이터 건수
	public int getTotalCount(Criteria cri);

	//첨부파일 단건조회
	public BoardAttachVO attachRead(String uuid);
}
