package co.yujeong.friend.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yujeong.friend.service.FriendService;
import co.yujeong.friend.service.FriendServiceImpl;
import co.yujeong.friend.vo.FriendVO;

public class FriendDeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FriendService dao = new FriendServiceImpl();
		FriendVO vo = new FriendVO();
		vo.setId(request.getParameter("id"));
		int n = dao.friendDelete(vo);
		String view;
		if (n != 0) {
			request.removeAttribute("yujeong");
			view = "friendList.do";
		} else {
			request.setAttribute("message", "존재하지 않는 친구 입니다");
			view = "friend/friendDeleteFail";
		}
		return view;
	}

}
