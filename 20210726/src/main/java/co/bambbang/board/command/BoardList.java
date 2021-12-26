package co.bambbang.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.bambbang.board.service.BoardService;
import co.bambbang.board.serviceImpl.BoardServiceImpl;
import co.bambbang.board.vo.BoardVO;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// show the list of the articles
		BoardService dao = new BoardServiceImpl();
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		list=dao.boardSelectList();
		request.setAttribute("boards", list);
		
		return "board/boardList";
	}

}
