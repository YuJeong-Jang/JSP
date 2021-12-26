package com.yj.app.emp.service;

import java.util.List;

import com.yj.app.emp.domain.EmpVO;

public interface EmpService {

	// CRUD

	// 전체조회
	public List<EmpVO> getList(EmpVO vo);

	// 단건조회
	public EmpVO read(EmpVO vo);

	// 등록
	public int insert(EmpVO vo);

	// 수정
	public int update(EmpVO vo);

	// 삭제
	public int delete(EmpVO vo);
}
