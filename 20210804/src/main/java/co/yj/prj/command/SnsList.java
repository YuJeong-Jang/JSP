package co.yj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.prj.board.service.BoardService;
import co.yj.prj.board.serviceImpl.BoardServiceImpl;
import co.yj.prj.common.Command;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// sns 목록 가져오기
		BoardService boardDao = new BoardServiceImpl();
//		List<SnsVO> list = new ArrayList<SnsVO>();
//		list = boardDao.snsSelectList();
		request.setAttribute("list", boardDao.snsSelectList()); //위 두줄 대신에 이렇게 써도 됨
//		request.setAttribute("lists", list);
		return "board/snsList";
	}

}
