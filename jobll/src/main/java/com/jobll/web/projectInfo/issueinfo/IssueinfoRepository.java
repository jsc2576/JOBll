package com.jobll.web.projectInfo.issueinfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IssueinfoRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	
	public int createAtcl(IssueInfo entity){
		int qry = sqlSession.insert("com.jobll.web.projectInfo.issueinfo.IssueInfo.create", entity);
		return qry;
	}
	

	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색) 
	 * @param entity
	 * @return
	 */
	public List<IssueInfo> findList(IssueInfo entity) throws Exception{
		List<IssueInfo> atcl_list = null;
		
		atcl_list = sqlSession.selectList("com.jobll.web.projectInfo.issueinfo.IssueInfo.findAll", entity);
		
		return atcl_list;
	}
	
	public IssueInfo findOne (IssueInfo entity) throws Exception{
		entity = sqlSession.selectOne("com.jobll.web.projectInfo.issueinfo.IssueInfo.findOne", entity);
		return entity;
	}
}
