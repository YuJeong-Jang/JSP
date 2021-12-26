package com.yj.app.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yj.app.sample.mapper.Sample1Mapper;
import com.yj.app.sample.mapper.Sample2Mapper;

@Service
public class SampleServiceImpl implements SampleService{

	@Autowired Sample1Mapper sample1;
	@Autowired Sample2Mapper sample2;
	
	@Override
	//@Transactional //aop-context에서 자동으로 트랜잭션이 들어가도록 넣어놔서 이 어노테이션은 안넣어줘도 됨
	public void addData(String value) {
		sample1.insert(value);
		sample2.insert(value);
	}
//	하나의 값을 받아와서 여러 테이블에 넣어야 할때, 하나라도 에러가 나면 전체 롤백이 되어야지
//	되는건 들어가고 안되는건 안들어가면 일관성에 위배됨
//	그래서 하나라도 에러가 뜨면 전체 롤백 하자는 목적으로 쓰는게 transaction이다
//	커넥션을 받아와서 execute하고 그게 안된다면 롤백하는 구조를 자동으로 하게 만들어 주는것.
	
}
