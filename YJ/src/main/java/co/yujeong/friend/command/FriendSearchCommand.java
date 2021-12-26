package co.yujeong.friend.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yujeong.friend.service.FriendService;
import co.yujeong.friend.service.FriendServiceImpl;
import co.yujeong.friend.vo.FriendVO;

public class FriendSearchCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FriendService dao = new FriendServiceImpl();
		FriendVO vo = new FriendVO();
		vo.setId(request.getParameter("id"));
		vo = dao.friendSelect(vo);
		if (vo.getName() != null) {
			request.setAttribute("yujeong", vo);
		} else {
			request.setAttribute("message", "�������� �ʴ� ģ�� �Դϴ�.");
		}
		return "friend/friendSearch";
	}

}
