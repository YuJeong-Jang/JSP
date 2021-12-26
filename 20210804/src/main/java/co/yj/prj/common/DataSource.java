package co.yj.prj.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSession;

	private DataSource() {
	} // 나를 바깥에서 생성하지 못하도록 만든다

	public static SqlSessionFactory getInstance() {
		try {
			String resource = "/mybatis-Config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(inputStream);

//			String resource = "org/mybatis/example/mybatis-config.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
