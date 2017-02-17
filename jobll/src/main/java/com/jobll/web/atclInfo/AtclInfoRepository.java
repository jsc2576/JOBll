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
	
	public List<AtclInfo> findAll(AtclInfo entity){
		List<AtclInfo> atcl_list = sqlSession.selectList("com.jobll.web.atclInfo.AtclInfo.findAll", entity);
		return atcl_list;
	}
	
	public List<AtclInfo> findRcvWait(AtclInfo atcl){
		
		return null;
	}
	
	public List<AtclInfo> findRcvCmpt(AtclInfo atcl){
		return null;
	}
	
	public List<AtclInfo> findPrcsWait(AtclInfo atcl){
		return null;
	}
	
	public List<AtclInfo> findPrcsCmpt(AtclInfo atcl){
		return null;
	}
}
