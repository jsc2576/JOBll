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
	

	// 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색) 	
	public PrjtCnetList findOne (PrjtCnetList entity) throws Exception{
		entity = sqlSession.selectOne("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.findOne", entity);
		return entity;
	}
	

	
	//아이디로 회사찾기
	public List<UsrInfo> findCmpnyIdx(List<String> prjtCnetInvList){
		List selectList = sqlSession.selectList("com.jobll.web.projectInfo.prjtCnetList.PrjtCnetList.findCmpnyIdx", prjtCnetInvList);
		return selectList;
	}
}