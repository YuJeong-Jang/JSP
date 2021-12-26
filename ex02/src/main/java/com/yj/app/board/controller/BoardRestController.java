package com.yj.app.board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.app.board.domain.BoardVO;

//@RestController 	// -> rest는 return값을 텍스트로 인식한다.
// = @Controller + @ResponseBody
@Controller
public class BoardRestController {

	@RequestMapping("test1")
	@ResponseBody // 자바 객체를 json형태로 바꿔주는 것
	public Map<String, Object> test1(@RequestParam String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		if (id.equals("admin")) {
			map.put("result", true);
		}
		// return "Admin true"; // hello.jsp -> json, xml, text
		else {
			map.put("result", false);
		}
		// return "User";
		return map;
	}

	//@RequestMapping(value = "test2", produces = { org.springframework.http.MediaType.APPLICATION_XML_VALUE,
	//												org.springframework.http.MediaType.APPLICATION_JSON_VALUE} )
	@GetMapping(value = "test2")
	@ResponseBody 
	public BoardVO test2(BoardVO vo) {
		vo.setBno(10);
		vo.setContent("dddd");
		vo.setRegDate(new Date());
		return vo;
	}
}
