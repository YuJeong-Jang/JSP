package co.yj.Lms.sns.service;

import java.util.List;

import co.yj.Lms.sns.vo.CommentsVO;
import co.yj.Lms.sns.vo.SnsVO;

public interface SnsService {
	List<SnsVO> snsSelectlist();

	List<SnsVO> snsSelect(int no);

//주 글의 업데이트 문들
	int snsInsert(SnsVO vo);

	int snsDelete(SnsVO vo);

	int snsUpdate(SnsVO vo);

//댓글의 업데이트 문들
	int commentsInsert(CommentsVO vo);

	int commentsDelete(CommentsVO vo);

	int commentsUpdate(CommentsVO vo);
}
