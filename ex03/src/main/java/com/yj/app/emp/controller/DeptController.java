package com.yj.app.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.app.emp.domain.DeptsVO;
import com.yj.app.emp.service.DeptsService;

@Controller
public class DeptController {

	@Autowired DeptsService deptsService;
	
	//부서관리 페이지
	@GetMapping("dept")
	public String dept() {
		return "emp/dept";
	}
	//ajax : 목록, 등록, 수정, 삭제
	@GetMapping("deptList")
	@ResponseBody
	public List<DeptsVO> deptList() {
		return deptsService.getDeptList();
	}
	
	//부서검색
	@RequestMapping("deptSearch")
	public String deptSearch(Model model) {
		model.addAttribute("deptList", deptsService.getDeptList());
		return "emp/deptSearch";
	}
	
	//직무번호 검색
	@RequestMapping("ajaxDept")
	@ResponseBody
	public DeptsVO ajaxDept(DeptsVO vo) {
		return deptsService.read(vo);
	}
}
