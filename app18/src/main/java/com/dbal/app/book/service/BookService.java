package com.dbal.app.book.service;

import java.util.List;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.model.RentVO;

public interface BookService {

	// 전체조회
	public List<BookVO> getList(BookVO vo);

	// 단건조회
	public BookVO read(BookVO vo);

	// 등록
	public int insert(BookVO vo);

	// 대여현황
	public List<RentVO> getListAll(RentVO vo);
}
