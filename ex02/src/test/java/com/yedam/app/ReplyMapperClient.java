package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yj.app.board.domain.Criteria;
import com.yj.app.reply.mapper.ReplyMapper;
import com.yj.app.reply.service.ReplyService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class ReplyMapperClient {

	@Autowired ReplyMapper replyMapper;
	@Autowired ReplyService replyService;
	
	@Test
	public void getList() {
		Criteria cri = new Criteria(1,10);
		//소문자 l 혹은 L을 써주면 long 타입을 불러오는것
	//log.info(replyMapper.getList(cri, 512L).toString());
		log.info(replyService.getList(cri, 512L).toString());
	}
}
