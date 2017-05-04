package com.jobll.web.qst;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QstRepository {

	@Autowired
	SqlSession sqlSession;
	
	public List<Qst> findQstList(Qst entity){
		return sqlSession.selectList("com.jobll.web.qna.findQstList", entity);
	}
}
