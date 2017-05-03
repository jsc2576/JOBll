package com.jobll.web.dashbrd;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DashbrdRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<String> findCuntPrjtSbjt(Dashbrd entity){
		return sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtSbjt", entity);
	}
	
	public List<String> findCentPrjtSbjt(Dashbrd entity){
		return sqlSession.selectList("com.jobll.seb.dashbrd.findCentPrjtSbjt", entity);
	}
}
