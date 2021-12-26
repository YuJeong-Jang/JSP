package com.yj.app.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.app.board.domain.Criteria;
import com.yj.app.board.mapper.BoardMapper;
import com.yj.app.reply.domain.ReplyPageVO;
import com.yj.app.reply.domain.ReplyVO;
import com.yj.app.reply.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired ReplyMapper replyMapper;
	@Autowired BoardMapper boardMapper;
	
	@Override
	public int insert(ReplyVO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return replyMapper.insert(vo);
	}

	@Override
	public int update(ReplyVO vo) {
		return replyMapper.update(vo);
	}

	@Override
	public int delete(ReplyVO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return replyMapper.delete(vo);
	}

	@Override
	public ReplyVO read(ReplyVO vo) {
		return replyMapper.read(vo);
	}

	@Override
	public ReplyPageVO getList(Criteria cri, long bno) {
		ReplyPageVO vo = new ReplyPageVO();
		vo.setReplyCnt(replyMapper.getCountByBno(bno));
		vo.setList(replyMapper.getList(cri, bno));
		return vo;
	}

	@Override
	public int getCountByBno(long bno) {
		return replyMapper.getCountByBno(bno);
	}


}
