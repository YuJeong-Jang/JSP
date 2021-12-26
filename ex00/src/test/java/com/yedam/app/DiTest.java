package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class DiTest {
	//IoC(Import of Control : 역제어) : 객체관리를 컨테이너가 함
	//Di : dependency Injection
	@Autowired
	Employees emp; 		//new 객체생성 없이 컨테이너에서 주입받음
	
	@Test
	public void test1() {
//		emp.getEmployee_id();
		log.info(emp.getEmployeeId());
	}
}
