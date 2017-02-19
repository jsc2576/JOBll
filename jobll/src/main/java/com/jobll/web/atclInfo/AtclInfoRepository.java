package com.jobll.web.atclInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AtclInfoRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	public int createAtcl(AtclInfo entity){
		int qry = sqlSession.insert("com.jobll.web.atclInfo.AtclInfo.create", entity);
		return qry;
	}
	

	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색) 
	 * @param entity
	 * @return
	 */
	public List<AtclInfo> findList(AtclInfo entity, Integer prcv_nm){
		List<AtclInfo> atcl_list = null;
		
		if(prcv_nm == 0){
			atcl_list = sqlSession.selectList("com.jobll.web.atcl.Atcl.findAll");
		}
		else if(prcv_nm < 5 && prcv_nm > 0){
			atcl_list = sqlSession.selectList("com.jobll.web.atcl.Atcl.findPrcs", prcv_nm);
		}
		
		return atcl_list;
	}
}