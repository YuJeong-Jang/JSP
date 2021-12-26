package co.yj.memberProj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yj.memberProj.common.Command;
import co.yj.memberProj.common.DAO;
import co.yj.memberProj.member.service.MemberService;
import co.yj.memberProj.member.serviceImpl.MemberServiceImpl;
import co.yj.memberProj.member.vo.MemberVO;

public class DeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService mDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setEmail(request.getParameter("email"));
		mDao.memberDelete(vo);
		request.setAttribute("delete", mDao.MemberSelectList());
		SqlSession sqlSession = DAO.getInstance().openSession();
		sqlSession.close();
		return "exam/main";
	}

}
