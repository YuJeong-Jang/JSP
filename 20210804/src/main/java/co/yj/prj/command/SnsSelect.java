package co.yj.prj.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.prj.board.service.BoardService;
import co.yj.prj.board.serviceImpl.BoardServiceImpl;
import co.yj.prj.board.vo.SnsVO;
import co.yj.prj.common.Command;

public class SnsSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// sns 한건조회
		BoardService boardDao = new BoardServiceImpl();
		SnsVO vo = new SnsVO();
		vo.setSNo(Integer.valueOf(request.getParameter("sno")));
		request.setAttribute("sns", boardDao.snsSelect(vo));
//		System.out.println(boardDao.snsSelect(vo).get(0).getcNo());
		return "board/snsSelect";
	}

}
