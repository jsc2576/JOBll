package com.jobll.web.projectInfo.projectSupply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobll.web.projectInfo.ProjectInfo;

@Repository
public class ProjectSupplyRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	
	public int create(ProjectSupply entity)throws Exception{
		int qry = sqlSession.insert("com.jobll.web.projectInfo.projectSupply.ProjectSupply.create", entity);
		return qry;
	}
	
	public List<ProjectSupply> findAll(ProjectSupply entity) throws Exception{
		List<ProjectSupply> list = sqlSession.selectList("com.jobll.web.projectInfo.projectSupply.ProjectSupply.findAll", entity);
		
		return list;
	}
	
	public ProjectSupply findOne (ProjectSupply entity) throws Exception{
		ProjectSupply data = sqlSession.selectOne("com.jobll.web.projectInfo.projectSupply.ProjectSupply.findOne", entity);
		return data;
	}
}
