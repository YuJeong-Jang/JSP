package com.yj.app.emp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yj.app.emp.domain.EmpVO;
import com.yj.app.emp.service.DeptsService;
import com.yj.app.emp.service.EmpService;
import com.yj.app.emp.service.JobsService;

@Controller
@RequestMapping("/emp/*")
public class EmpController {

	@Autowired EmpService empService;
	@Autowired JobsService jobsService;
	@Autowired DeptsService deptsService;
	
	//전체조회
	  @GetMapping("/empList") 
	  public void list(Model model, EmpVO vo) { 
		  model.addAttribute("list", empService.getList(vo));
	  }
	 
	  //수정 폼
	  @GetMapping("updateEmp")
	  public String insertFormEmp(EmpVO vo, Model model) {
		  model.addAttribute("emp", empService.getList(vo));
		  return "emp/empRegister";
	  }
	  
	//수정처리 -> 완료후 페이지 전환
	@PostMapping("/empModify")
	public String modify(EmpVO vo, RedirectAttributes rttr) {
		int result = empService.update(vo);
		if (result == 1) {
			rttr.addAttribute("result", "success");
		}
		return "redirect:emp/empList";
	}
	
	@ModelAttribute("opt")
	public Map<String, Object> jobs() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobs", jobsService.getJobList());
		map.put("depts", deptsService.getDeptList());
		return map;
	}
	//등록페이지
	@GetMapping("/empRegister")
	public String registerForm(EmpVO vo) {
		return "no/emp/empRegister";
	}
	
	//등록처리 -> 등록후 페이지 전환
	@PostMapping("/empRegister")
	public String register(EmpVO vo, RedirectAttributes rttr) {
		empService.insert(vo);
		rttr.addFlashAttribute("result", vo.getEmployeeId());
		return "redirect:/emp/empList";
	}
	
	//사원검색
	@RequestMapping("empSearch")
	public String empSearch(Model model, EmpVO vo) {
		model.addAttribute("empList", empService.getList(vo));
		return "emp/empSearch";
	}
	
	//직무번호 검색
	@RequestMapping("ajaxEmp")
	@ResponseBody
	public EmpVO ajaxEmp(EmpVO vo) {
		return empService.read(vo);
	}
	
	//이메일 검색
	@RequestMapping("ajaxEmail")
	@ResponseBody
	public EmpVO ajaxEmail(EmpVO vo) {
		return empService.read(vo);
	}
}
