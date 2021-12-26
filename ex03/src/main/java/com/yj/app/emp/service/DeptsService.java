package com.yj.app.emp.service;

import java.util.List;

import com.yj.app.emp.domain.DeptsVO;

public interface DeptsService {

	//전체조회
	public List<DeptsVO> getDeptList();
	
	//단건조회
	public DeptsVO read(DeptsVO vo);
}
