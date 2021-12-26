package co.yj.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yj.prj.common.DAO;
import co.yj.prj.member.service.MemberService;
import co.yj.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hoddy"));
				vo.setAuthor(rs.getString("author"));
				//vo.setState(rs.getString("state");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return members;
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public MemberVO memberSelect(MemberVO vo) {
		String sql = "select * from member where id = ?";
		try {
		conn = DAO.getConnection();
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, vo.getId());
		rs = psmt.executeQuery();
		if (rs.next()) {
			vo.setName(rs.getString("name"));
			vo.setPassword(rs.getString("password"));
			vo.setAge(rs.getInt("age"));
			vo.setHobby(rs.getString("hoddy"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return vo;
}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// TODO 로그인 체크
		String sql = "select name, author from member where id = ? and password = ? and state = 'Y'";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setAuthor(rs.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int n = 0;
		String sql = "insert into member values(?, ?, ?, ? ,?)";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getAge());
			psmt.setString(5, vo.getHobby());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int n = 0;
		String sql = "delete from member where id = ?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		int n = 0;
		String sql = "update member set password=?, hobby=? where id = ? ";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPassword());
			psmt.setString(2, vo.getHobby());
			psmt.setString(3, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
}