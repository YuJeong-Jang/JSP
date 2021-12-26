package com.yedam.app;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.Impl.EmpMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class EmpMapperClient {

	@Autowired
	EmpMapper dao;
	@Autowired SqlSessionTemplate mybatis;
	
	@Test
	public void mybatisTest() {
//		map = vo
		List<Employees> list = mybatis.selectList("com.yedam.app.Impl.EmpMapper.getEmp", "10");
		log.info("job_id = " + list.get(0).getJobId()); 		//jsp ${emp.xxx}
//		List<Departments> list = mybatis.selectList("com.yedam.app.Impl.EmpMapper.getDept");
//		log.info(list.toString());
	}
//	select - 단건
//	selectCursor - 커서
//	selectList - 리스트
//	selectMap - map형태
	
	
//	@Test
//	public void test() {
//		log.info(dao.getEmp("10").toString());
//		log.info(dao.getDept().toString());
//	}
//
//	@Test
//	public void getTime() {
//		log.info("time==" + dao.getTime().toString());
//	}
}
