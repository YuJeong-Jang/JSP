package com.yj.app.emp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yj.app.emp.domain.DeptsVO;

@Repository
public interface DeptsMapper {

	//전체조회
	public List<DeptsVO> getDeptList();

	//단건조회
	public DeptsVO read(DeptsVO vo);
}
