package com.jobll.web.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

import com.jobll.web.home.Home;

@Repository
public class HomeRepository {

	@Autowired
	SqlSession sqlSession;

	public int create(Home entity) throws Exception {

		return sqlSession.insert("com.jobll.web.home.Home.create", entity);

	}

}