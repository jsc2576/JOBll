package com.jobll.web.dashbrd;

import java.util.List;

import org.apache.catalina.manager.util.SessionUtils;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobll.web.SessionUtil;

@Repository
public class DashbrdRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//최근 프로젝트
	public List<Dashbrd> findCuntPrjtSbjt(Dashbrd entity){
		//List<String> prjt_idx_list = sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtIdx", entity);
		//return sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtSbjt", prjt_idx_list);
		return null;
		//List<String> prjt_idx_list = sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtIdx", entity);
		//return sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtSbjt", prjt_idx_list);
	}
	//담당 프로젝트
	public List<Dashbrd> findCentPrjtSbjt(Dashbrd entity){
		
		//List<String> prjt_idx_list = sqlSession.selectList("com.jobll.web.dashbrd.findCentPrjtIdx", entity);
		//return sqlSession.selectList("com.jobll.web.dashbrd.findCentPrjtSbjt", prjt_idx_list);
		return null;
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
