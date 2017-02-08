package com.jobll.web.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

@Repository
public class MemberRepositoryImpl {
	@Autowired
    SqlSession sqlSession;
	
	public List<HashMap<String, Object>> select(Member entity) throws Exception{
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.member.Member.select");
		return selectList ;
	}
	public List<HashMap<String, Object>> read(Member entity){
		return null;
	}
	public int create(Member entity){
		return 1;
	};
	public int edit(Member entity){
		return 1;
	};
	public int delete(Member entity){
		return 1;
	};

}