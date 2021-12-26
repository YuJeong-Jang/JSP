package co.bambbang.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.bambbang.board.service.BoardService;
import co.bambbang.board.serviceImpl.BoardServiceImpl;
import co.bambbang.board.vo.BoardVO;

public class BoardSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO one row search
		
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		vo=dao.boardSelect(vo);
		request.setAttribute("board", vo);
		
		return "board/boardSelect";
	}

}
