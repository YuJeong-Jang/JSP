package com.yj.app.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.app.emp.domain.EmpVO;
import com.yj.app.emp.mapper.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper empMapper;

	@Override
	public List<EmpVO> getList(EmpVO vo) {
		return empMapper.getList(vo);
	}

	@Override
	public EmpVO read(EmpVO vo) {
		return empMapper.read(vo);
	}

	@Override
	public int insert(EmpVO vo) {
		return empMapper.insert(vo);
	}

	@Override
	public int update(EmpVO vo) {
		return empMapper.update(vo);
	}

	@Override
	public int delete(EmpVO vo) {
		return empMapper.delete(vo);
	}
}
