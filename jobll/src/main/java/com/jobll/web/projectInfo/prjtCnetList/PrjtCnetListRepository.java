package com.jobll.web.projectInfo.prjtCnetList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobll.web.usrinfo.UsrInfo;



@Repository
public class PrjtCnetListRepository {
	@Autowired
    SqlSession sqlSession;
	
	public List<PrjtCnetList> selectPrjtCnetList(PrjtCnetList entity) throws Exception{
		List<PrjtCnetList> list = null;
		
		list = sqlSession.selectList("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.selectPrjtCnetList", entity);
		
		return list;
	}
	
	public List<PrjtCnetList> deletePrjtCnetList(Integer prjt_idx) {
		
		List selectList = sqlSession.selectList("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.delete", prjt_idx);

		return selectList ;
	}

	public List<UsrInfo> selectCnetList() {
		
		List selectList = sqlSession.selectList("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.selectCnetList");
		
		return selectList ;
	}
	
	public void createPrjtCnetList(Map<String, Object> map){
		 sqlSession.insert("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.create", map);
		
	}
	

	

	//
	// 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색) 
	// @param entity
	// @return
	//
	public List<PrjtCnetList> findList(PrjtCnetList entity) throws Exception{
		List<PrjtCnetList> prjtCnetList_list = null;
		
		if(entity.getPrjt_idx() == 0){
			prjtCnetList_list = sqlSession.selectList("com.jobll.projectInfo.web.prjtCnetList.PrjtCnetList.findAll", entity);
		}
		else if(entity.getPrjt_idx() < 5 && entity.getPrjt_idx() > 0){
			prjtCnetList_list = sqlSession.selectList("com.jobll.projectInfo.web.prjtCnetList.PrjtCnetList.findPrcs", entity);
		}
		
		return prjtCnetList_list;
	}
	
	public PrjtCnetList findOne (PrjtCnetList entity) throws Exception{
		entity = sqlSession.selectOne("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.findOne", entity);
		return entity;
	}
	
	
	public List<HashMap<String, Object>> select() {
		
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.select");
		return selectList ;
	}
	
	public List<HashMap<String, Object>> read(PrjtCnetList entity){
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.read",entity);
		return selectList ;
	};
	

	
	public int edit(PrjtCnetList entity){
		
		int test = sqlSession.insert("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.edit",entity);
		return test;
	}

	public int delete(PrjtCnetList entity){
		int test = sqlSession.insert("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.delete",entity);
		return test;
	}
	
	//아이디로 회사찾기
	public List<UsrInfo> findCmpnyIdx(List<String> prjtCnetInvList){
		List selectList = sqlSession.selectList("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.findCmpnyIdx", prjtCnetInvList);
		return selectList;
	}
}