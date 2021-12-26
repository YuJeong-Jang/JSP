package com.yj.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class PasswordTest {

	@Test
	public void encodingTest() {
		
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
	String result = encoder.encode("1234");
	String result2 = encoder.encode("1234");
//	같은 비밀번호라도 암호화 할때마다 값이 달라짐
//	db에 있는 암호화된 값이랑 사용자가 가진 암호화 값이랑 매치시켜서 암호화값을 비교할 수 있음
	log.info(result);
	log.info(result2);
	assertTrue(encoder.matches("1234", result));
	}
}
