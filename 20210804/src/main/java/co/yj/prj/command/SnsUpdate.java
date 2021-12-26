package co.yj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.prj.board.service.BoardService;
import co.yj.prj.board.serviceImpl.BoardServiceImpl;
import co.yj.prj.board.vo.SnsVO;
import co.yj.prj.common.Command;

public class SnsUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 수정
		BoardService boardDao = new BoardServiceImpl();
		SnsVO vo = new SnsVO();
		System.out.println(request.getParameter("num"));
		vo.setSNo(Integer.valueOf(request.getParameter("num")));
		
		vo.setSTitle(request.getParameter("stitle"));
		vo.setSContents(request.getParameter("scontents"));

		request.setAttribute("update", vo);
		return "snsSelect.do";
	}

}
