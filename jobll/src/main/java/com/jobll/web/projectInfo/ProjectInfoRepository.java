package com.jobll.web.projectInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobll.web.atclInfo.AtclInfo;

@Repository
public class ProjectInfoRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	
	public int create(ProjectInfo entity){
		int qry = sqlSession.insert("com.jobll.web.projectInfo.ProjectInfo.create", entity);
		return qry;
	}
	
	public List<ProjectInfo> findList(ProjectInfo entity) throws Exception{
		List<ProjectInfo> project_list = sqlSession.selectList("com.jobll.web.projectInfo.ProjectInfo.findAll", entity);
		
		return project_list;
	}
	
	public ProjectInfo findOne(ProjectInfo entity) throws Exception{
		ProjectInfo project = sqlSession.selectOne("com.jobll.web.projectInfo.ProjectInfo.findOne", entity);
		
		return project;
	}

}
