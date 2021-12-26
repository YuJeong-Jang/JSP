package co.yj.memberProj.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yj.memberProj.common.DAO;
import co.yj.memberProj.member.service.MemberService;
import co.yj.memberProj.member.serviceImpl.MemberServiceImpl;
import co.yj.memberProj.member.vo.MemberVO;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = dao.MemberSelectList();
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
		System.out.println(list);
		SqlSession sqlSession = DAO.getInstance().openSession();
		sqlSession.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

}
