package com.goodfile.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBeen {
	
	private static SqlSessionFactory sessionFactory = null;
	
	static {
		if(sessionFactory == null) {
			try(Reader reader = Resources.getResourceAsReader("com/goodfile/db/dbConfig.xml")){
				
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				
			}catch (IOException e) {
				e.printStackTrace();
			}//end try
		}//end if
	}//end static 

	public static SqlSession getSqlSession() {
		//openSession를 얻을 때 매개변수로 true를 넣어주면 autocommit이다 기본값은 false
		return sessionFactory.openSession();
	}
	
	
}
