package com.yedam.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yj.app.board.domain.BoardVO;
import com.yj.app.board.domain.Criteria;
import com.yj.app.board.mapper.BoardMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class BoardMapperClient {
	
	//@Autowired BoardService boardMapper;
	@Autowired BoardMapper boardMapper;
	
	@Test
	public void getList() {
		Criteria cri = new Criteria(1,20);
		cri.setType("C");
		cri.setKeyword("검색");
		log.info(boardMapper.getList(cri).toString());
	}
	
	//@Test
	public void insert() {
		//BoardVO 생성
		BoardVO vo = new BoardVO();
		vo.setTitle("시퀀스");
		vo.setContent("이상하다?");
		vo.setWriter("유정");
		boardMapper.insert(vo);
		log.info(Long.toString(vo.getBno()));
	}
	
	//@Test
	public void read() {
		BoardVO vo = new BoardVO();
		vo.setBno(7);
		boardMapper.read(vo);
//		vo = boardMapper.read(vo);
//		log.info(vo.toString());
	}
	
	//@Test
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setBno(7);
		vo.setTitle("어허");
		vo.setContent("이이이잉입니다.");
		boardMapper.update(vo);
		log.info(vo.toString());
	}
	
	//@Test
	//@Rollback
	public void delete() {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		int result = boardMapper.delete(vo);
		assertEquals(result, 1);
	}
}
