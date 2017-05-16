package com.jobll.web.qst.qstOne;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QstOneRepository {

	@Autowired
	SqlSession sqlSession;
	
	public QstOne findQstOne(QstOne entity){
		return sqlSession.selectOne("com.jobll.web.qst.qstOne.findQstOne", entity);
	}
	
}
