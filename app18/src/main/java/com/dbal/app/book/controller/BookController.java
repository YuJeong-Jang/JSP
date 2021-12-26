package com.dbal.app.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.model.RentVO;
import com.dbal.app.book.service.BookService;

@Controller
@RequestMapping("/book/*")
public class BookController {

	@Autowired
	BookService bookService;

	// 단건조회(수정페이지)
	@GetMapping("/get")
	public void get(Model model, BookVO vo) {
		model.addAttribute("book", bookService.read(vo));
	}

	// 전체조회
	@GetMapping("/list")
	public void list(Model model, BookVO vo) {
		model.addAttribute("list", bookService.getList(vo));
	}

	// 등록페이지
	@GetMapping("/register")
	public void registerForm() {

	}

	// 등록처리
	@PostMapping("/register")
	public String register(BookVO vo, RedirectAttributes rttr) {
		bookService.insert(vo);
		rttr.addFlashAttribute("result", vo.getBookNo());
		return "redirect:/book/list";
	}
	
	// 전체조회
		@GetMapping("/total")
		public void total(Model model, RentVO vo) {
			model.addAttribute("total", bookService.getListAll(vo));
		}
}
