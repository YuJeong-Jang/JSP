package co.bambbang.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.bambbang.board.service.BoardService;
import co.bambbang.board.serviceImpl.BoardServiceImpl;
import co.bambbang.board.vo.BoardVO;

public class InsertBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardService dao = new BoardServiceImpl();
		BoardVO vo=new BoardVO();
		vo.setbWriter(request.getParameter("bWriter"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		
		int n=0;
		n=dao.boardInsert(vo);
		
		
		
		return "boardList.do";
	}

}
