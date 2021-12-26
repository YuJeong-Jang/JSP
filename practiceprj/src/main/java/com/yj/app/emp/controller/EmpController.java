package com.yj.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yj.app.emp.domain.EmpVO;
import com.yj.app.emp.service.EmpService;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log
@Controller
@RequestMapping("/emp/*")
public class EmpController {

	@Autowired EmpService empService;
	
	//전체조회
	@GetMapping("/empList")
	public void list(Model model, EmpVO vo) {
		model.addAttribute("list", empService.getList(vo));
	}
	
	//단건조회(수정페이지)
	@RequestMapping("empSearch")
	public void empSearch(Model model, EmpVO vo) {
		log.info("search============="+vo.getEmployeeId());
		model.addAttribute("empList", empService.read(vo));
	}
	
	//수정
	@PutMapping("/update")
	public String update(EmpVO vo, RedirectAttributes rttr) {
		int result = empService.update(vo);
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");			
		}
		return "redirect:/emp/empList";
	}
	
	//등록 페이지
	@GetMapping("/empInsert")
	public void insertFrom() {
	}
	
	//등록
	@PostMapping("/empInsert")
	public String insert(EmpVO vo, RedirectAttributes rttr) {
		log.info("vo=============="+vo);
		empService.insert(vo);
		rttr.addFlashAttribute("result", vo.getEmployeeId());
		return "redirect:/emp/empList";
	}
	
	
	//삭제
	@DeleteMapping("/delete")
	public String delete(EmpVO vo, RedirectAttributes rttr) {
		int result = empService.delete(vo);
		if (result == 1) {
			rttr.addAttribute("result", "success");		
		}
		return "redirect:/emp/empList";
	}
}
