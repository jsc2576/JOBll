package com.jobll.web.dashbrd;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DashbrdRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//최근 프로젝트
	public List<Dashbrd> findCuntPrjtSbjt(Dashbrd entity){
		List<Dashbrd> prjt_idx_list = sqlSession.selectList("com.jobll.web.dashbrd.findCuntPrjtIdx", entity);

		for(int i=0; i<prjt_idx_list.size(); i++){
			Integer prjt_idx = prjt_idx_list.get(i).getPrjt_idx();
			Dashbrd sbjt = sqlSession.selectOne("com.jobll.web.dashbrd.findPrjtSbjt", prjt_idx);
			prjt_idx_list.get(i).setPrjt_sbjt(sbjt.getPrjt_sbjt());
		}
		
		return prjt_idx_list;
	}
	//담당 프로젝트
	public List<Dashbrd> findCentPrjtSbjt(Dashbrd entity){
		List<Dashbrd> prjt_idx_list = sqlSession.selectList("com.jobll.web.dashbrd.findCnetPrjtIdx", entity);

		for(int i=0; i<prjt_idx_list.size(); i++){
			Integer prjt_idx = prjt_idx_list.get(i).getPrjt_idx();
			Dashbrd sbjt = sqlSession.selectOne("com.jobll.web.dashbrd.findPrjtSbjt", prjt_idx);
			prjt_idx_list.get(i).setPrjt_sbjt(sbjt.getPrjt_sbjt());
		}
		
		return prjt_idx_list;
	}
	
	public Integer[] AtclCnt(Dashbrd entity){
		Integer[] Cnt = new Integer[3];
		
		Cnt[0] = sqlSession.selectOne("com.jobll.web.dashbrd.AtclTotCnt", entity);
		Cnt[1] = sqlSession.selectOne("com.jobll.web.dashbrd.AtclRmnCnt", entity); 
		Cnt[2] = sqlSession.selectOne("com.jobll.web.dashbrd.AtclEndCnt", entity);
		
		return Cnt;
	}
	
	public List<Dashbrd> findRcntAtclList(Dashbrd entity){
		List<Dashbrd> data = sqlSession.selectList("com.jobll.web.dashbrd.findRcntAtclList", entity);
		List<Dashbrd> result = new ArrayList<>();
		for(int i=0; i<data.size(); i++){
			Dashbrd data_one = sqlSession.selectOne("com.jobll.web.dashbrd.findAtcl", data.get(i));
			result.add(data_one);
		}
		return result;
	}
}
