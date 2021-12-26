package co.bambbang.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.bambbang.board.command.DAO;
import co.bambbang.board.service.BoardService;
import co.bambbang.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private void close() {
		//close the connection
		try {
			if(rs !=null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn !=null) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<BoardVO> boardSelectList() {
		// all the board list
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql="select * from board order by bid desc";
		
		try {
			conn=DAO.getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				vo= new BoardVO();
				vo.setbId(rs.getInt("bId"));
				vo.setbTitle(rs.getString("bTitle"));
//				vo.setbContent(rs.getString("bContent"));
				vo.setbWriter(rs.getString("bWriter"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO Auto-generated method stub
		String sql="select * from board where bid=?";
		
		try {
			conn=DAO.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				vo.setbId(rs.getInt("bId"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbWriter(rs.getString("bWriter"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
				
				hitUpdate(vo.getbId());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	private void hitUpdate(int id) {
		// TODO Auto-generated method stub
		String sql="update board set bhit = bhit+1 where bid=?";
		
		try {
			//conn=DAO.getConnection(); 이미 Boardselect 에서 해서 안해도 된대...
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	@Override
	public int boardInsert(BoardVO vo) {
		// 글추가하기
		String sql="insert into board (bid, btitle, bcontent, bwriter,bdate) values(b_seq.nextval, ?,?,?,?)";
		int n=0;
		
		try {
			conn=DAO.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setString(3, vo.getbWriter());	
			psmt.setDate(4, vo.getbDate());	
			n=psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		String sql="delete from board where id=?";
		int n=0;
		
		try {
			conn=DAO.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n=psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	@Override
	public int boardUpdate(BoardVO vo) {
		// update only the content and the title
		String sql="update board set btitle=?, bcontent=? where id=?";
		int n = 0;
		
		try {
			conn=DAO.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setInt(3, vo.getbId());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

}
