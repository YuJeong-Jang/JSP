package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yj.app.sample.service.SampleService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class SampleServiceClient {

	@Autowired SampleService sampleService;
	
	@Test
	public void test() {
		String str = "no1 123456789";
		sampleService.addData(str);
		log.info("length = " + str.getBytes().length);
	}
//	sample1 -> 20byte
//	sample2 -> 10byte
//	sample1에는 들어가지만 sample2에는 안들어가니까 전체 롤백이 되서 두 테이블에 전부 안들어감
}
