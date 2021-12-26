package co.yj.prj.comm;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;

	private DataSource() {
	}

	public static SqlSessionFactory getInstance() {

		try {
			String resources = "config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resources); //propertires를 읽음 (key and value로 읽어서 각각 대입시킴)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //읽어온 값을 객체로 던져줌
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}

}
