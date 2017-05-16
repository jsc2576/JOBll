package com.jobll.web.qst.qstList;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QstListRepository {

	@Autowired
	SqlSession sqlSession;
	
	public List<QstList> findQstList(QstList entity){
		return sqlSession.selectList("com.jobll.web.qst.qstList.findQstList", entity); 
	}
	
	public Integer findQstListCnt(QstList entity){
		return sqlSession.selectOne("com.jobll.web.qst.qstList.findQstListCnt", entity);
	}
	
	public List<QstList> findAnsQstList(QstList entity){
		List<QstList> data = sqlSession.selectList("com.jobll.web.qst.qstList.findAnsQstList", entity);
		return data;
	}
}
