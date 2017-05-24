package com.jobll.web.qstList;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobll.web.CommonUtil;
import com.jobll.web.SessionUtil;
import com.jobll.web.projectInfo.projectSupply.ProjectSupply;

@Repository
public class QstListRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public int create(QstList entity) throws Exception{
		int qry = sqlSession.insert("com.jobll.web.qstList.QstList.create", entity);
		return qry;
	}
	
	public List<QstList> findAll(QstList entity)throws Exception {
		List<QstList> list = sqlSession.selectList("com.jobll.web.qstList.QstList.findAll", entity); 
		
		return list;
	}
	
	public List<QstList> findMyQst(QstList entity)throws Exception {
		List<QstList> list = sqlSession.selectList("com.jobll.web.qstList.QstList.findMyQst", entity); 
		
		return list;
	}
	
	public QstList findOne (QstList entity) throws Exception{
		QstList data = sqlSession.selectOne("com.jobll.web.qstList.QstList.findOne", entity);
		return data;
	}
	public int update (QstList entity) throws Exception{
		int data = sqlSession.update("com.jobll.web.qstList.QstList.modify", entity);
		return data;
	}
}
