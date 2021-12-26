package com.yj.app.reply.service;

import org.apache.ibatis.annotations.Param;

import com.yj.app.board.domain.Criteria;
import com.yj.app.reply.domain.ReplyPageVO;
import com.yj.app.reply.domain.ReplyVO;


public interface ReplyService {
	// CRUD
	// 등록
	public int insert(ReplyVO vo);

	// 수정
	public int update(ReplyVO vo);

	// 삭제
	public int delete(ReplyVO vo);

	// 단건조회
	public ReplyVO read(ReplyVO vo);

	// 전체조회
	// 여기서 값을 넘겨야한다. pageNum, amount
	public ReplyPageVO getList(@Param("cri") Criteria cri,@Param("bno")  long bno);

	// 해당 게시글의 댓글 수
		public int getCountByBno(long bno);

}
