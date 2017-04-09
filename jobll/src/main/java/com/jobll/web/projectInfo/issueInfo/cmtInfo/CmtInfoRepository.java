package com.jobll.web.projectInfo.issueInfo.cmtInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CmtInfoRepository {

	@Autowired
	private SqlSession sqlSession;


	public int create(CmtInfo entity) throws Exception{
		int qry = sqlSession.insert("com.jobll.web.projectInfo.issueInfo.cmtInfo.CmtInfo.create", entity);
		return qry;
	}

	public List<CmtInfo> findAll(CmtInfo entity)  throws Exception{
		List<CmtInfo> list = sqlSession.selectList("com.jobll.web.projectInfo.issueInfo.cmtInfo.CmtInfo.findAll", entity);
		return list;
	}

	public CmtInfo findOne(CmtInfo entity)  throws Exception{
		CmtInfo data = sqlSession.selectOne("com.jobll.web.projectInfo.issueInfo.cmtInfo.CmtInfo.findOne", entity);
		return data;
	}
	public int delete(CmtInfo entity) throws Exception{
		int qry = sqlSession.update("com.jobll.web.projectInfo.issueInfo.cmtInfo.CmtInfo.delete", entity);
		return qry;
	}
	public int update(CmtInfo entity) throws Exception{
		int qry = sqlSession.update("com.jobll.web.projectInfo.issueInfo.cmtInfo.CmtInfo.update", entity);
		return qry;
	}

}