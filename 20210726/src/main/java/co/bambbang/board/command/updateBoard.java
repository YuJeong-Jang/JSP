package co.bambbang.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.bambbang.board.service.BoardService;
import co.bambbang.board.serviceImpl.BoardServiceImpl;
import co.bambbang.board.vo.BoardVO;

public class updateBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		int n = 0;
		n = dao.boardUpdate(vo);
		return "boardList.do";
	}

}
