package com.yj.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yj.app.board.domain.BoardAttachVO;
import com.yj.app.board.domain.BoardVO;
import com.yj.app.board.domain.Criteria;

@Repository
public interface BoardMapper {
	// CRUD
	// 등록
	public int insert(BoardVO vo);

	// 수정
	public int update(BoardVO vo);

	// 삭제
	public int delete(BoardVO vo);

	// 단건조회
	public BoardVO read(BoardVO vo);

	// 전체조회
	// 여기서 값을 넘겨야한다. pageNum, amount
	public List<BoardVO> getList(Criteria cri);

	// 전체 데이터 건수
	public int getTotalCount(Criteria cri);

	// 댓글 수 업데이트
	public int updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	//첨부파일 단건조회
	public BoardAttachVO attachRead(String uuid);

}
