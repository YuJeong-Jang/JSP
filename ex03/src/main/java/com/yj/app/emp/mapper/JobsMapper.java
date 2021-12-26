package com.yj.app.emp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yj.app.emp.domain.JobsVO;

@Repository
public interface JobsMapper {

	//전체조회
	public List<JobsVO> getJobList();

}
