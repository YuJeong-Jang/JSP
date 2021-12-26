package co.yj.prj.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//싱글톤클래스(한번만 클래스를 만드는것) 인스탄스를 만들어도 주소가 동일하다
//자기자신을 스타틱하게 만들어서 나의 생성자를 프라이빗으로 만듬 그래서 나만 생성할수있는거임
//외부로 내보내고 싶으면 인스탄트를 만들어서 나를 쓸수 있게끔 한다

public class DataSource {
	public static DataSource dataSource = new DataSource(); // 중요한 부분. 외부 객체가 나를 생성하지 못하도록 막는 부분. 자기 자신의 인스턴스
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;

	private DataSource() {
		// 생성자(외부에서 생성하지 못하게 자신의 생성자를 private으로 만듬)
	}

	public static DataSource getInstance() { //외부에서 사용시 인스턴스를 리턴한다
		return dataSource;
	}

	public Connection getConnection() {
		configure(); // 외부 properties를 읽어온다.
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private void configure() {
		Properties properties = new Properties(); // 외부에 properties라는 파일명을 읽어들인다
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
