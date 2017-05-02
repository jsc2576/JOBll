package com.jobll.web.dashbrd;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DashbrdRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//최근 프로젝트\
	public List<Dashbrd> findCuntPrjtSbjt(Dashbrd entity){
		//return sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtIdx", entity);
		List<String> prjt_idx_list = sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtIdx", entity);
		return sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtSbjt", prjt_idx_list);
		//List<String> prjt_idx_list = sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtIdx", entity);
		//return sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtSbjt", prjt_idx_list);
	}
	//담당 프로젝트
	public List<Dashbrd> findCentPrjtSbjt(Dashbrd entity){
		return sqlSession.selectList("com.jobll.web.dashbrd.findCentPrjtIdx", entity);
		//List<String> prjt_idx_list = sqlSession.selectList("com.jobll.web.dashbrd.findCentPrjtIdx", entity);
		//return sqlSession.selectList("com.jobll.web.dashbrd.findCentPrjtSbjt", prjt_idx_list);
		//return null;
	}
	
	public Integer AtclTotCnt(Dashbrd entity){
		return sqlSession.selectOne("com.jobll.web.dashbrd.AtclTotCnt", entity);
	}
	
	public Integer AtclRmnCnt(Dashbrd entity){
		return sqlSession.selectOne("com.jobll.web.dashbrd.AtclRmnCnt", entity);
	}
	
	public Integer AtclEndCnt(Dashbrd entity){
		return sqlSession.selectOne("com.jobll.web.dashbrd.AtclEnd	Cnt", entity);
	}
}
