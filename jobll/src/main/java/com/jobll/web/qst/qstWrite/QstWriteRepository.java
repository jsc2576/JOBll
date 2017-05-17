package com.jobll.web.qst.qstWrite;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QstWriteRepository {

	@Autowired
	SqlSession sqlSession;
	
	public int create(QstWrite entity){
		return sqlSession.insert("com.jobll.web.qst.qstWrite.create", entity);
	}
}
