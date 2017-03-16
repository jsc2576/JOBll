package com.jobll.web.prjtCnetList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobll.web.usrinfo.UsrInfo;



@Repository
public class PrjtCnetListRepository {
	@Autowired
    SqlSession sqlSession;
	
	
	public List<PrjtCnetList> selectPrjtCnetList() {
		
		List selectList = sqlSession.selectList("com.jobll.web.prjtCnetList.PrjtCnetList.selectPrjtCnetList");
		
		return selectList ;
	}
	
	
	public List<UsrInfo> selectCnetList() {
		
		List selectList = sqlSession.selectList("com.jobll.web.prjtCnetList.PrjtCnetList.selectCnetList");
		
		return selectList ;
	}
	
	public int createPrjtCnetList(PrjtCnetList entity){
		int qry = sqlSession.insert("com.jobll.web.prjtCnetList.PrjtCnetList.create", entity);
		return qry;
	}

	//
	// 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색) 
	// @param entity
	// @return
	//
	public List<PrjtCnetList> findList(PrjtCnetList entity) throws Exception{
		List<PrjtCnetList> prjtCnetList_list = null;
		
		if(entity.getPrjt_idx() == 0){
			prjtCnetList_list = sqlSession.selectList("com.jobll.web.prjtCnetList.PrjtCnetList.findAll", entity);
		}
		else if(entity.getPrjt_idx() < 5 && entity.getPrjt_idx() > 0){
			prjtCnetList_list = sqlSession.selectList("com.jobll.web.prjtCnetList.PrjtCnetList.findPrcs", entity);
		}
		
		return prjtCnetList_list;
	}
	
	public PrjtCnetList findOne (PrjtCnetList entity) throws Exception{
		entity = sqlSession.selectOne("com.jobll.web.prjtCnetList.PrjtCnetList.findOne", entity);
		return entity;
	}
	
	
	public List<HashMap<String, Object>> select() {
		
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.prjtCnetList.PrjtCnetList.select");
		return selectList ;
	}
	
	public List<HashMap<String, Object>> read(PrjtCnetList entity){
		List<HashMap<String, Object>> selectList = new ArrayList<HashMap<String, Object>>();
		selectList  = sqlSession.selectList("com.jobll.web.prjtCnetList.PrjtCnetList.read",entity);
		return selectList ;
	};
	
	public int create(PrjtCnetList entity){
		
		int test = sqlSession.insert("com.jobll.web.prjtCnetList.PrjtCnetList.create",entity);
		return test;
	}
	
	public int edit(PrjtCnetList entity){
		
		int test = sqlSession.insert("com.jobll.web.prjtCnetList.PrjtCnetList.edit",entity);
		return test;
	}

	public int delete(PrjtCnetList entity){
		int test = sqlSession.insert("com.jobll.web.prjtCnetList.PrjtCnetList.delete",entity);
		return test;
	}
}