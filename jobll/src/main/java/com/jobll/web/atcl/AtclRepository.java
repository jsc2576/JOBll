package com.jobll.web.atcl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AtclRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	public List<Atcl> findAll(Atcl entity){
		List<Atcl> atcl_list = sqlSession.selectList("com.jobll.web.atcl.Atcl.findAll", entity);
		return atcl_list;
	}
	
	public List<Atcl> findRcvWait(Atcl atcl){
		
		return null;
	}
	
	public List<Atcl> findRcvCmpt(Atcl atcl){
		return null;
	}
	
	public List<Atcl> findPrcsWait(Atcl atcl){
		return null;
	}
	
	public List<Atcl> findPrcsCmpt(Atcl atcl){
		return null;
	}
}
