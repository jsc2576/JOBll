package com.jobll.web.projectInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectInfoRepository {
	
	@Autowired
    private SqlSession sqlSession;
	
	
	public int create(ProjectInfo entity){
		int qry = sqlSession.insert("com.jobll.web.projectInfo.ProjectInfo.create", entity);
		return qry;
	}
	

}
