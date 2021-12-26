package co.yujeong.friend.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yujeong.friend.service.FriendService;
import co.yujeong.friend.service.FriendServiceImpl;
import co.yujeong.friend.vo.FriendVO;

public class FriendListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	FriendService dao = new FriendServiceImpl();
	List<FriendVO> friends = new ArrayList<FriendVO>();
	friends = dao.friendSelectAll();
	request.setAttribute("list", friends);
		return "friend/friendList";
	}

}
