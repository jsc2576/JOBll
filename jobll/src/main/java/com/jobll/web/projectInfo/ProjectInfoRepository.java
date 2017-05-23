package com.jobll.web.projectInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobll.web.usrinfo.UsrInfo;

@Repository
public class ProjectInfoRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	
	public int create(ProjectInfo entity){
		int qry = sqlSession.insert("com.jobll.web.projectInfo.ProjectInfo.create", entity);
		return qry;
	}
	public int delete(ProjectInfo entity){
		int qry = sqlSession.update("com.jobll.web.projectInfo.ProjectInfo.delete", entity);
		return qry;
	}
	public int modify(ProjectInfo entity){
		int qry = sqlSession.update("com.jobll.web.projectInfo.ProjectInfo.modify", entity);
		return qry;
	}
	
	public List<ProjectInfo> findList(ProjectInfo entity) throws Exception{
		List<ProjectInfo> project_list = sqlSession.selectList("com.jobll.web.projectInfo.ProjectInfo.findAll", entity);
		
		return project_list;
	}
	
	public ProjectInfo findChildren(ProjectInfo entity) throws Exception{
		ProjectInfo project = sqlSession.selectOne("com.jobll.web.projectInfo.ProjectInfo.findChildren", entity);
		
		return project;
	}
	
	public ProjectInfo findOne(ProjectInfo entity) throws Exception{
		ProjectInfo project = sqlSession.selectOne("com.jobll.web.projectInfo.ProjectInfo.findOne", entity);
		
		return project;
	}
	
	public List<ProjectInfo> find(ProjectInfo entity) throws Exception{
		List<ProjectInfo> project_list = sqlSession.selectList("com.jobll.web.projectInfo.ProjectInfo.find", entity);
		
		return project_list;
	}
}
