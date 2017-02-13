package com.jobll.web.usrinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UsrInfoRepositoryImpl extends SqlSessionDaoSupport {

	public List<HashMap<String, Object>> select(UsrInfo entity) {
		
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = getSqlSession().selectList("com.jobll.web.usrinfo.UsrInfo.select",entity);
		return selectList ;
	}
	
	public List<HashMap<String, Object>> read(UsrInfo entity){
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = getSqlSession().selectList("com.jobll.web.usrinfo.UsrInfo.read",entity);
		return selectList ;
	};
	
	public int create(UsrInfo entity){
		
		int test = getSqlSession().insert("com.jobll.web.usrinfo.UsrInfo.create",entity);
		return test;
	}
	
	public int edit(UsrInfo entity){
		
		int test = getSqlSession().insert("com.jobll.web.usrinfo.UsrInfo.edit",entity);
		return test;
	}

	public int delete(UsrInfo entity){
	
	int test = getSqlSession().insert("com.jobll.web.usrinfo.UsrInfo.delete",entity);
	return test;
}

}
