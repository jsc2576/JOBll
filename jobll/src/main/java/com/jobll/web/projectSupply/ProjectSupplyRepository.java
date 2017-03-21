package com.jobll.web.projectSupply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobll.web.projectInfo.ProjectInfo;

@Repository
public class ProjectSupplyRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	
	public int create(ProjectSupply entity){
		int qry = sqlSession.insert("com.jobll.web.projectSupply.ProjectSupply.create", entity);
		return qry;
	}
	

	/**
	 * 데이터 검색 (0: 전체검색, 1: 대기중 검색, 2: 접수 완료 검색, 3: 처리중 검색, 4: 처리완료 검색) 
	 * @param entity
	 * @return
	 */
	public List<ProjectSupply> findList(ProjectSupply entity) throws Exception{
		List<ProjectSupply> projectSupply_list = sqlSession.selectList("com.jobll.web.projectSupply.ProjectSupply.findAll", entity);
		
		return projectSupply_list;
	}
	
	public ProjectSupply findOne (ProjectSupply entity) throws Exception{
		ProjectSupply project = sqlSession.selectOne("com.jobll.web.projectSupply.ProjectSupply.findOne", entity);
		return project;
	}
}
