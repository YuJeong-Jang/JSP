package co.yj.prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public Connection conn;

	public DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "demo", "demo");
			System.out.println("아싸뵹~");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("슈방?");
		}
//dao는 생성하고 항상 제일먼저 연결을 확인해주는게 좋다.
	}

}
