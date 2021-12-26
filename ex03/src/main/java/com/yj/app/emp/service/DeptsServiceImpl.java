package com.yj.app.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.app.emp.domain.DeptsVO;
import com.yj.app.emp.mapper.DeptsMapper;

@Service
public class DeptsServiceImpl implements DeptsService{

	@Autowired DeptsMapper deptsMapper;
	
	@Override
	public List<DeptsVO> getDeptList() {
		return deptsMapper.getDeptList();
	}

	@Override
	public DeptsVO read(DeptsVO vo) {
		return deptsMapper.read(vo);
	}
	

}
