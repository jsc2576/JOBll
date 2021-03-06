package com.jobll.web.projectInfo.issueInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IssueInfoRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	
	public int create(IssueInfo entity){
		int qry = sqlSession.insert("com.jobll.web.projectInfo.issueInfo.IssueInfo.create", entity);
		return qry;
	}
	

	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색) 
	 * @param entity
	 * @return
	 */
	public List<IssueInfo> findList(IssueInfo entity) throws Exception{
		List<IssueInfo> atcl_list = null;
		
		atcl_list = sqlSession.selectList("com.jobll.web.projectInfo.issueInfo.IssueInfo.findAll", entity);
		
		return atcl_list;
	}
	
	public IssueInfo findOne (IssueInfo entity) throws Exception{
		entity = sqlSession.selectOne("com.jobll.web.projectInfo.issueInfo.IssueInfo.findOne", entity);
		return entity;
	}
	
	public String findToTypCnt (IssueInfo entity) throws Exception{
		String count = sqlSession.selectOne("com.jobll.web.projectInfo.issueInfo.IssueInfo.findToTypCnt", entity);
		return count;
	}
	
	public int delete(IssueInfo entity){
		int qry = sqlSession.update("com.jobll.web.projectInfo.issueInfo.IssueInfo.delete", entity);
		return qry;
	}
	
	public int update(IssueInfo entity){
		int qry = sqlSession.update("com.jobll.web.projectInfo.issueInfo.IssueInfo.update", entity);
		return qry;
	}
}
