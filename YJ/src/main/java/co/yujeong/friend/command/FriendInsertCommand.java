package co.yujeong.friend.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yujeong.friend.service.FriendService;
import co.yujeong.friend.service.FriendServiceImpl;
import co.yujeong.friend.vo.FriendVO;

public class FriendInsertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FriendService dao = new FriendServiceImpl();
		FriendVO vo = new FriendVO();
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		for (String str : hobbys) {
			hobby += str + ",";
		}
		hobby = hobby.substring(0, hobby.length() - 1);

		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.valueOf(request.getParameter("age")));
		vo.setHobby(hobby);
		int n = dao.friendInsert(vo);
		String view;
		if (n != 0) {
			view = "friendList.do";
		} else {
			request.setAttribute("message", "입력 실패 쨔응");
			view = "friend/friendInsertFail";
		}
		return view;
	}

}
