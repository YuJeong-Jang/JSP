package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yj.app.user.domain.UserVO;
import com.yj.app.user.service.UserService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml" )
public class AopClient {

	@Autowired UserService userService;
	
	@Test
	public void test1() {
		UserVO vo = new UserVO();
		vo.setId("test");
		userService.getUserList(vo);
		//userService.getUserList(null);	
	}
}
