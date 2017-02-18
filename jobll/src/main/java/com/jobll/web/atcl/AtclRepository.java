package com.jobll.web.atcl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AtclRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색) 
	 * @param entity
	 * @return
	 */
	public List<Atcl> findList(Atcl entity, Integer prcv_nm){
		List<Atcl> atcl_list = null;
		
		if(prcv_nm == 0){
			atcl_list = sqlSession.selectList("com.jobll.web.atcl.Atcl.findAll", entity);
		}
		else if(prcv_nm < 5 && prcv_nm > 0){
			atcl_list = sqlSession.selectList("com.jobll.web.atcl.Atcl.findPrcs", prcv_nm);
		}
		
		return atcl_list;
	}
}
