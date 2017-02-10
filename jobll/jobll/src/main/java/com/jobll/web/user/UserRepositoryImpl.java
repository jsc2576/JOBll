package com.jobll.web.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

@Repository
public class UserRepositoryImpl {
	@Autowired
    SqlSession sqlSession;
	
	public List<HashMap<String, Object>> select(User entity) throws Exception{
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.user.User.select");
		return selectList ;
	}
	public List<HashMap<String, Object>> read(User entity){
		return null;
	}
	public int create(User entity){
		return 1;
	};
	public int edit(User entity){
		return 1;
	};
	public int delete(User entity){
		return 1;
	};

}