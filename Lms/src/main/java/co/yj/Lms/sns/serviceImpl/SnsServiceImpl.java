package co.yj.Lms.sns.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yj.Lms.common.DAO;
import co.yj.Lms.sns.service.SnsService;
import co.yj.Lms.sns.vo.CommentsVO;
import co.yj.Lms.sns.vo.SnsVO;

public class SnsServiceImpl implements SnsService {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<SnsVO> snsSelectlist() {
		// sns 글 목록을 가져온다
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		String sql = "select * from sns";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsAno(rs.getInt("sano"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public List<SnsVO> snsSelect(int no) {
		// 글을 선택하면 댓글을 포함해서 가져온다.
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		String sql = "select a.*, b.cname, b.csubject, b.cdate from sns a left outer join comments b on (a.sno = b.sno) where a.sno = ?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsContents(rs.getString("scontents"));
				vo.setsAno(rs.getInt("sano")); // 댓글갯수
				vo.setcName(rs.getString("cname"));
				vo.setcSubject(rs.getString("csubject"));
				vo.setcDate(rs.getDate("cdate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int snsInsert(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int snsDelete(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
