package com.dbal.app.book.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.book.mapper.BookMapper;
import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.model.RentVO;
import com.dbal.app.book.service.BookService;


@Service
public class BookServiceImpl implements BookService {

	@Autowired BookMapper bookMapper;

	@Override
	public List<BookVO> getList(BookVO vo) {
		return bookMapper.getList(vo);
	}

	@Override
	public int insert(BookVO vo) {
		return bookMapper.insert(vo);
	}

	@Override
	public BookVO read(BookVO vo) {
		return bookMapper.read(vo);
	}

	@Override
	public List<RentVO> getListAll(RentVO vo) {
		return bookMapper.getListAll(vo);
	}


}
