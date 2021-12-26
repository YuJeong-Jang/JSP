package co.yujeong.friend.service;

import java.util.List;

import co.yujeong.friend.vo.FriendVO;

public interface FriendService {
	List<FriendVO> friendSelectAll();

	FriendVO friendSelect(FriendVO vo);

	int friendInsert(FriendVO vo);

	int friendDelete(FriendVO vo);

	int friendUpdate(FriendVO vo);
}
