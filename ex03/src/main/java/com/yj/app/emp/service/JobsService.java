package com.yj.app.emp.service;

import java.util.List;

import com.yj.app.emp.domain.JobsVO;

public interface JobsService {

	//전체조회
	public List<JobsVO> getJobList();

}
