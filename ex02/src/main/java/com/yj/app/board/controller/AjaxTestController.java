package com.yj.app.board.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.app.board.domain.BoardVO;
import com.yj.app.board.domain.Criteria;

@Controller
public class AjaxTestController {

	//@GetMapping("/ajax1")
	@ResponseBody
	public 	BoardVO test1(BoardVO vo) {
		vo.setContent("content test");
		return vo;
	}
	
	//@PostMapping("/ajax2")
	@ResponseBody
	public 	BoardVO test2(@RequestBody BoardVO vo) {
		vo.setContent("content test");
		return vo;
	}
	
}
