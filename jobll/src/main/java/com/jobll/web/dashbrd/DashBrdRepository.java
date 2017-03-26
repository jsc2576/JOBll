package com.jobll.web.dashbrd;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class DashBrdRepository {

	SqlSession sqlSession;
	
	public List<String> findPrjtSbjt(DashBrd entity){
		List<Integer> prjt_idx = sqlSession.selectList("com.jobll.web.dashbrd.DashBrd.findPrjtIdx", entity);
		
		
		return null;
	}
}
