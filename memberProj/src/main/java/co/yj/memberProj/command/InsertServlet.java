package co.yj.memberProj.command;

import java.io.IOException;
import java.sql.Date;

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

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setEmail(request.getParameter("email"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		vo.setAddr(request.getParameter("addr"));
		vo.setBirth(Date.valueOf(request.getParameter("birth")));
		dao.memberInsert(vo);
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));
		System.out.println(vo);
		SqlSession sqlSession = DAO.getInstance().openSession();
		sqlSession.close();
	}

}
