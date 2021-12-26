package com.yedam.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;

//pojo : 상속 x
@Controller // ->@Component 상속해서 @Controller, @Service, @Repository(=dao)

//같은 sample 아래의 경로라면 이렇게 메인경로를 먼저 매핑해주고 그 아래에 상세 경로들을 매핑해준다.
@RequestMapping("/sample/*")
@Log
public class SampleController {

	@RequestMapping("/ex09") 
	@ResponseBody	//자바객체 -> json 스트링 변환
	public SampleVO ex09(SampleVO sample) {
		//SampleVO sample = new SampleVO();
		sample.setName("한글");
		sample.setAge(50);
		return sample;
	}
	
	@RequestMapping("/ex06/{name}/{age}")
	public void ex06(@PathVariable String name, @PathVariable int age) {
	//id=ddd&age=13 형태가 아닌 ddd/13 형태로 호출
	log.info("name = " + name + ", age = " + age);
	}
	
	@RequestMapping("/ex05")
	public void ex05(SampleVoList list) {
		log.info(list.toString());
	}
	
	@RequestMapping("/ex04")
	public void ex04(@RequestParam List<String> ids) {
		log.info(ids.toString());
		//list나 배열(array)나 같다
	}
	
	@RequestMapping("/ex03")
	public void ex03(@RequestParam String[] ids) {
		//String[] ids = request.getParameterValues("ids");
		log.info(Arrays.toString(ids));
	}
	@GetMapping("/ex02")
	//요기에 쓴 파라미터는 필수값
	public void ex02(@RequestParam(name = "username") String name, @RequestParam(required = false, defaultValue = "10") int age) {
		//username 파라미터로 들어온 값은 name 변수에 담겠다.
		//age파라미터는 필수가 아니고, 디폴트 값은 10으로 넣어주겠다.
		//String name = request.getParameter("name")
		log.info("name = " + name + ", age = " + age);
	}
	
	@GetMapping("/ex01")
	//@ModelAttribute("xxx") -> 파라미터 명을 명명
	public String ex01(@ModelAttribute("sam") SampleVO vo, Model model) {	//dto = vo = do
		log.info(vo.toString());
		//model.addAttribute("sampleVO", vo);
//		이걸 안써줘도 파라미터에 알아서 add됨
		model.addAttribute("pageNo", "10");
		return "sample/ex01";
	}
	
	@GetMapping("/a")
	//@RequestMapping(value = "/a", method = RequestMethod.POST)
	public String basic() { // jsp 뷰페이지 리턴
		log.info("basic1.................");
		return "sample/a";
	}

	@RequestMapping("/b")
	public void basic2() { // void 인 경우 url과 일치하는 뷰페이지로 포워드
		log.info("basic2.................");
	}
}
