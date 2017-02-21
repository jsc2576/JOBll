package com.jobll.web.usrinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.mybatis.spring.support.SqlSessionDaoSupport;
@Repository("usr_info")
public class UsrInfoRepository {
	
	@Autowired
    SqlSession sqlSession;
	
	
	public List<HashMap<String, Object>> select() {
		
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.usrinfo.UsrInfo.select");
		return selectList ;
	}
	
	public List<HashMap<String, Object>> read(UsrInfo entity){
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.usrinfo.UsrInfo.read",entity);
		return selectList ;
	};
	
	public int create(UsrInfo entity){
		
		int test = sqlSession.insert("com.jobll.web.usrinfo.UsrInfo.create",entity);
		return test;
	}
	
	public int edit(UsrInfo entity){
		
		int test = sqlSession.insert("com.jobll.web.usrinfo.UsrInfo.edit",entity);
		return test;
	}

	public int delete(UsrInfo entity){
	
	int test = sqlSession.insert("com.jobll.web.usrinfo.UsrInfo.delete",entity);
	return test;
}
	public int checkId(UsrInfo entity){
		int test = sqlSession.selectOne("com.jobll.web.usrinfo.UsrInfo.checkId",entity.getUsr_id());
		return test;
	}
}
